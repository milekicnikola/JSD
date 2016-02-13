

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

homeTeam = entities.Team(name="Crvena zvezda", coach='null', players=homePlayers)
gameInfo = entities.GameInfo(city="Belgrade", arena="Pionir", attendance=6479, \
    crew_chief=ref1, referee=ref2, umpire=ref3, date='13-Feb-2016', time='19:45')
game = entities.Game(game_info=gameInfo, home_team=homeTeam, away_team='null')

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

with open('generatedStats.html', 'w') as f:
    f.write(output_from_parsed_template)
