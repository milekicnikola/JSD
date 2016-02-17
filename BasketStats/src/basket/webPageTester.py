

import os, sys
from entities import entities

print(sys.version)

ref1 = entities.Person("MIGUEL", "PEREZ", "ESP")
ref2 = entities.Person("TOLGA ", "SAHIN", "ITA")
ref3 = entities.Person("AARE ", "HALLIKO", "EST")


player1 = entities.Player("KINSEY", "TARENCE", nationality="USA",
    number=1, position=entities.Position.PG)

player2 = entities.Player("REBIC", "NIKOLA", nationality="SRB",
    number=4, position=entities.Position.C)

homePlayers = [player1, player2]

homeTeam = entities.Team(name="Crvena Zvezda Telekom Belgrade", coach='null', players=homePlayers)
awayTeam = entities.Team(name="Lokomotiv Kuban Krasnodar", coach='null', players=homePlayers)

refs = [ref1, ref2, ref3]
gameInfo = entities.GameInfo(city="Belgrade", arena="Pionir", attendance=6479, \
    referees=refs, date='13-Feb-2016', time='19:45')

game = entities.Game(game_info=gameInfo, home_team=homeTeam, away_team=awayTeam)
game.home_team.coach = entities.Person(first_name="DEJAN", last_name="RADONJIC", nationality="MNE")
game.away_team.coach = entities.Person(first_name="GEORGIOS", last_name="BARTZOKAS", nationality="GRE")

# Jinja2 Test
'''from jinja2 import Template
t = Template("Hello {{ something }}!")
print(t.render(something="World"))
t = Template("My favorite numbers: {% for n in range(1,10) %}{{n}} " "{% endfor %}")
print(t.render())'''

print('\n\n')

#Real Jinja2 magic
from jinja2 import Environment, FileSystemLoader
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
