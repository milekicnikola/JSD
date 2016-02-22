

import sys

from jinja2 import Environment, FileSystemLoader

from entities import entities


print(sys.version)

ref1 = entities.Person("MIGUEL", "PEREZ", "ESP")
ref2 = entities.Person("TOLGA ", "SAHIN", "ITA")
ref3 = entities.Person("AARE ", "HALLIKO", "EST")


player1 = entities.Player("KINSEY", "TARENCE", nationality="USA",
    number=1, position=entities.Position.PG)

player1.points = 23
player1.rebounds_offensive = 1
player1.rebounds_deffensive = 3
player1.two_points_made = 10
player1.two_points_attempted = 17
player1.three_points_made = 2
player1.three_points_attempted = 3
player1.free_throws_made = 1
player1.free_throws_attempted = 3
player1.assists = 3
player1.steals = 3
player1.turnovers = 1
player1.blocks_in_favor = 2


player2 = entities.Player("REBIC", "NIKOLA", nationality="SRB",
    number=4, position=entities.Position.C)

player2.points = 11
player2.rebounds_offensive = 4
player2.rebounds_deffensive = 11
player2.two_points_made = 3
player2.two_points_attempted = 5
player2.three_points_made = 1
player2.three_points_attempted = 5
player2.free_throws_made = 4
player2.free_throws_attempted = 4
player2.assists = 1
player2.steals = 5
player2.turnovers = 3
player2.blocks_in_favor = 5

homePlayers = [player1, player2]

homeTeam = entities.Team(name="Crvena Zvezda Telekom Belgrade", coach='null', players=homePlayers)
awayTeam = entities.Team(name="Lokomotiv Kuban Krasnodar", coach='null', players=homePlayers)


refs = [ref1, ref2, ref3]
gameInfo = entities.GameInfo(city="Belgrade", arena="Pionir", attendance=6479, \
    referees=refs, date='13-Feb-2016', time='19:45')

game = entities.Game(game_info=gameInfo, home_team=homeTeam, away_team=awayTeam, events=[])
game.home_team.coach = entities.Person(first_name="DEJAN", last_name="RADONJIC", nationality="MNE")
game.away_team.coach = entities.Person(first_name="GEORGIOS", last_name="BARTZOKAS", nationality="GRE")

game.home_team.firstQuarterPoints = 13
game.home_team.secondQuarterPoints = 23
game.home_team.thirdQuarterPoints = 15
game.home_team.fourthQuarterPoints = 10

# Jinja2 Test
'''from jinja2 import Template
t = Template("Hello {{ something }}!")
print(t.render(something="World"))
t = Template("My favorite numbers: {% for n in range(1,10) %}{{n}} " "{% endfor %}")
print(t.render())'''

print('\n\n')

#Real Jinja2 magic
env = Environment(loader=FileSystemLoader('templates'))

print(env.loader.list_templates())
print(env.loader.searchpath)

template = env.get_template('statsTemplate.html');
output_from_parsed_template = template.render(game=game)
'''output_from_parsed_template = \
    template.render(attendance='1311', \
    referees=[ref1.getFullNameWithNationality(), ref2.getFullNameWithNationality(), ref3.getFullNameWithNationality()])'''

with open('output/generatedStats.html', 'w') as f:
    f.write(output_from_parsed_template)
