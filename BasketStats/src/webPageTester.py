

import os, sys
from entities import entities

print(sys.version)

ref1 = entities.Person("MIGUEL", "PEREZ", "ESP")
print(ref1.first_name)
print(ref1.getFullName())

player1 = entities.Player("KINSEY", "TARENCE", nationality="USA",
    number=1, position=entities.Position.PG)
print(player1.getFullName())
print(player1.getPlayerSignature())
print(player1.getPlayerSignatureWithPosition())

# Jinja2 Test
from jinja2 import Template
t = Template("Hello {{ something }}!")
print(t.render(something="World"))
t = Template("My favorite numbers: {% for n in range(1,10) %}{{n}} " "{% endfor %}")
print(t.render())
