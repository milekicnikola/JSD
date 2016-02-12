

import os, sys
from entities import entities

print(sys.version)

ref1 = entities.Person("MIGUEL", "PEREZ", "ESP")
ref2 = entities.Person("TOLGA ", "SAHIN", "ITA")
ref3 = entities.Person("AARE ", "HALLIKO", "EST")


player1 = entities.Player("KINSEY", "TARENCE", nationality="USA",
    number=1, position=entities.Position.PG)
print(player1.getFullName())
print(player1.getPlayerSignature())
print(player1.getPlayerSignatureWithPosition())

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
output_from_parsed_template = \
    template.render(attendance='1311', \
    referees=[ref1.getFullNameWithNationality(), ref2.getFullNameWithNationality(), ref3.getFullNameWithNationality()])

with open('generatedStats.html', 'w') as f:
    f.write(output_from_parsed_template)
