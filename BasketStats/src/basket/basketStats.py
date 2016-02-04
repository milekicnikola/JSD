'''
Created on 04.02.2016.

@author: Nikola Milekic
'''
#===============================================================================
# from jinja2.environment import Environment
# from jinja2.loaders import PackageLoader
#===============================================================================
import pydot
from textx.export import metamodel_export, model_export
from textx.metamodel import metamodel_from_file


if __name__ == '__main__':

    basket_metamodel = metamodel_from_file('grammar.tx', debug = False)
    metamodel_export(basket_metamodel, 'basketStats_meta.dot')
    graph = pydot.graph_from_dot_file('basketStats_meta.dot')
    graph.write_png('basketStats_meta.png')
    
    #===========================================================================
    # object_processors = {'MoveCommand' : move_command_processor}
    # forma_mm.register_obj_processors(object_processors)
    #===========================================================================
    
    basket_model = basket_metamodel.model_from_file('game.tx')
    model_export(basket_model, 'basketStats_model.dot')
    graph = pydot.graph_from_dot_file('basketStats_model.dot')
    graph.write_png('basketStats_model.png')
    
    #===========================================================================
    # forma = Forma()
    # forma.interpret(forma_model)
    # print(forma)
    #===========================================================================
    
    #===========================================================================
    # env = Environment(trim_blocks = True, lstrip_blocks = True, loader = PackageLoader("forma","templates"))
    # env.filters['componentType'] = componentType
    # template = env.get_template("form.html")
    # t = template.render(model = forma_model)
    # print(t)
    # with open("output/form.html", "w") as f:
    #     f.write(t)
    #===========================================================================