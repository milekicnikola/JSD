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

    def getFullNameFormatted(self):
        return self.last_name + ', ' + self.first_name

    def getFullNameWithNationality(self):
        return self.getFullName() + ' (' + self.nationality + ')'

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
        self.time_played = '00:00'
        self.points = 0
        self.field_goals_made = 0
        self.field_goals_attempted = 0
        self.three_points_made = 0
        self.three_points_attempted = 0
        self.free_throws_made = 0
        self.free_throws_attempted = 0
        self.rebounds_offensive = 0
        self.rebounds_deffensive = 0
        self.assists = 0
        self.steals = 0
        self.turnovers = 0
        self.blocks_in_favor = 0
        self.blocks_against = 0
        self.fouls_commited = 0
        self.fouls_received = 0


    def getPlayerSignature(self):
        return '#' + str(self.number) + ' ' + self.last_name

    def getPlayerSignatureWithPosition(self):
        return self.getPlayerSignature() + ', ' + self.position.value

    def getTotalRebounds(self):
        return self.rebounds_deffensive + self.rebounds_offensive

    def getFieldGoalsMA(self):
        return str(self.field_goals_made) + '/' + str(self.field_goals_attempted)

    def getFreeThrowsMA(self):
        return str(self.free_throws_made) + '/' + str(self.free_throws_attempted)

    def getThreePointsMA(self):
        return str(self.three_points_made) + '/' + str(self.three_points_attempted)

    def getMissedFieldGoals(self):
        return self.field_goals_attempted - self.field_goals_made

    def getMissedFreeThrows(self):
        return self.free_throws_attempted - self.free_throws_made

    def getMissedThreePoints(self):
        return self.three_points_attempted - self.three_points_made

    '''(Points + Rebounds + Assists + Steals + Blocks + Fouls Drawn)
        - (Missed Field Goals + Missed Free Throws + Turnovers + Shots Rejected + Fouls Committed)'''
    def getPerformanceIndexRating(self):
        return (self.points + self.getTotalRebounds() + self.assists \
            + self.steals + self.blocks_in_favor + self.fouls_received) - \
            (self.getMissedFieldGoals() + self.getMissedFreeThrows() + self.turnovers + \
            self.blocks_against + self.fouls_commited)

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
