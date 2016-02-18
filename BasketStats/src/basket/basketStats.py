'''
Created on 04.02.2016.

@author: Nikola Milekic
'''
from jinja2.environment import Environment
from jinja2.loaders import PackageLoader
import pydot
from textx.export import metamodel_export, model_export
from textx.metamodel import metamodel_from_file

from basket.entities.entities import GameInfo, Referee, Player, Coach, Team

class Basket(object):
    
    game_info = GameInfo()
    home_team = Team()
    away_team = Team()
    
    def __init__(self):
        pass
        
    def interpret(self, model):
        
        '''Game Info'''
        
        self.game_info.city = model.info.city
        self.game_info.arena = model.info.arena
        self.game_info.date = model.info.date
        self.game_info.time = model.info.time
        self.game_info.attendance = model.info.att
        
        '''Referees'''
        
        referees = []
        
        referees.append(Referee(model.info.Referees.first.firstName, model.info.Referees.first.lastName, model.info.Referees.first.nat, "CrewChief"))
        referees.append(Referee(model.info.Referees.second.firstName, model.info.Referees.second.lastName, model.info.Referees.second.nat, "Referee"))
        referees.append(Referee(model.info.Referees.third.firstName, model.info.Referees.third.lastName, model.info.Referees.third.nat, "Umpire"))
        
        self.game_info.referees = referees     
        
        '''Teams - Home and Away'''
        
        homePlayers = []
        awayPlayers = []                       
        
        for n in model.info.homeTeam.players:
            p = Player(n.firstName, n.lastName, n.nat, n.number, n.position)                     
            homePlayers.append(p)
                         
        self.home_team.name = model.info.homeTeam.name
        self.home_team.coach = Coach(model.info.homeTeam.coach.firstName, model.info.homeTeam.coach.lastName, model.info.homeTeam.coach.nat)
        self.home_team.players = homePlayers
        
        for n in model.info.awayTeam.players:
            p = Player(n.firstName, n.lastName, n.nat, n.number, n.position)                     
            awayPlayers.append(p)
                    
        self.away_team.name = model.info.awayTeam.name
        self.away_team.coach = Coach(model.info.awayTeam.coach.firstName, model.info.awayTeam.coach.lastName, model.info.awayTeam.coach.nat)
        self.away_team.players = awayPlayers     
       
        
        #=======================================================================
        # print(model.info.arena)
        # entities.Team = model.info.homeTeam
        # entities.Player = model.info.homeTeam.players[0]
        # entities.Team.players = model.info.homeTeam.players
        #=======================================================================
        #=======================================================================
        # print(entities.HomeTeam.players[0].firstName)                
        #=======================================================================
                            
    def __str__(self):
        pass

if __name__ == '__main__':

    basket_metamodel = metamodel_from_file('grammar.tx', debug=False)
    metamodel_export(basket_metamodel, 'basketStats_meta.dot')
    graph = pydot.graph_from_dot_file('basketStats_meta.dot')
    graph.write_png('basketStats_meta.png')

    basket_model = basket_metamodel.model_from_file('game.tx')
    model_export(basket_model, 'basketStats_model.dot')
    graph = pydot.graph_from_dot_file('basketStats_model.dot')
    graph.write_png('basketStats_model.png')

    basket = Basket()
    basket.interpret(basket_model)

    env = Environment(trim_blocks=True, lstrip_blocks=True, loader=PackageLoader("basket", "templates"))
  
    template = env.get_template("statsTemplate.html")
    t = template.render(game=basket)
    print(t)
    with open("output/stats.html", "w") as f:
        f.write(t)
