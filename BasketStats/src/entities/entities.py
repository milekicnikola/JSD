from enum import Enum, unique
@unique
class Position(Enum):
    PG = 'PG'
    SG = 'SG'
    SF = 'SF'
    PF = 'PF'
    C = 'C'
    G = 'G'
    F = 'F'

class Person:

    def __init__(self, first_name, last_name, nationality):
        self.first_name = first_name
        self.last_name = last_name
        self.nationality = nationality

    def getFullName(self):
        return self.first_name + ' ' + self.last_name

class GameInfo:

    def __init__(self, city, arena, date, time, attendance, crew_chief, referee, umpire):
        self.city = city
        self.arena = arena
        self.date = date
        self.time = time
        self.attendance = attendance
        self.crew_chief = crew_chief
        self.referee = referee
        self.umpire = umpire

class Player(Person):

    def __init__(self,first_name, last_name, nationality, number, position):
        self.first_name = first_name
        self.last_name = last_name
        self.nationality = nationality
        self.number = number
        self.position = position

    def getPlayerSignature(self):
        return '#' + str(self.number) + ' ' + self.last_name

    def getPlayerSignatureWithPosition(self):
        return self.getPlayerSignature() + ', ' + self.position.value

class Team:

    def __init__(self, name, coach, players):
        self.name = name
        self.coach = coach
        self.players = players

class Game:

    def __init__(self, game_info, home_team, away_team):
        self.game_info = game_info
        self.home_team = home_team
        self.away_team = away_team
