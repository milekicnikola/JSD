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

class Game(object):
    def __init__(self, game_info, home_team, away_team, events):
        self.game_info = game_info
        self.home_team = home_team
        self.away_team = away_team
        self.events = events

class GameInfo:

    def __init__(self, city="", arena="", date="", time="", attendance="", referees=""):
        self.city = city
        self.arena = arena
        self.date = date
        self.time = time
        self.attendance = attendance
        self.referees = referees
        self.overtime = False

class Referee(Person):

    def __init__(self, first_name="", last_name="", nationality="", kind=""):
        self.first_name = first_name
        self.last_name = last_name
        self.nationality = nationality
        self.kind = kind

class Coach(Person):

    def __init__(self, first_name="", last_name="", nationality=""):
        self.first_name = first_name
        self.last_name = last_name
        self.nationality = nationality

class Player(Person):

    def __init__(self, first_name, last_name, nationality, number, position):
        self.first_name = first_name
        self.last_name = last_name
        self.nationality = nationality
        self.number = number
        self.position = position
        self.points = 0
        self.two_points_made = 0
        self.two_points_attempted = 0
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

    def getPoints(self):
        return self.free_throws_made + 2 * self.two_points_made + 3 * self.three_points_made

    def getTotalRebounds(self):
        return self.rebounds_deffensive + self.rebounds_offensive

    def getFieldGoalsMade(self):
        return self.two_points_made + self.three_points_made

    def getFieldGoalsAttempted(self):
        return self.two_points_attempted + self.three_points_attempted

    def getFieldGoalsMA(self):
        return str(self.getFieldGoalsMade()) + '/' + str(self.getFieldGoalsAttempted())

    def getTwoPointsMA(self):
        return str(self.two_points_made) + '/' + str(self.two_points_attempted)

    def getFreeThrowsMA(self):
        return str(self.free_throws_made) + '/' + str(self.free_throws_attempted)

    def getThreePointsMA(self):
        return str(self.three_points_made) + '/' + str(self.three_points_attempted)

    def getMissedFieldGoals(self):
        return self.getFieldGoalsAttempted() - self.getFieldGoalsMade()

    def getMissedTwoPoints(self):
        return self.two_points_attempted - self.two_points_made

    def getMissedFreeThrows(self):
        return self.free_throws_attempted - self.free_throws_made

    def getMissedThreePoints(self):
        return self.three_points_attempted - self.three_points_made

    def getFieldGoalsPercentage(self):
        if self.getFieldGoalsAttempted() != 0 :
            return round(self.getFieldGoalsMade() / self.getFieldGoalsAttempted() * 100, 1)
        else:
            return 0

    def getTwoPointsPercentage(self):
        if self.two_points_attempted != 0:
            return round(self.two_points_made / self.two_points_attempted * 100, 1)
        else:
            return 0

    def getThreePointsPercentage(self):
        if self.three_points_attempted != 0:
            return round(self.three_points_made / self.three_points_attempted * 100, 1)
        return 0

    def getFreeThrowsPercentage(self):
        if self.free_throws_attempted != 0:
            return round(self.free_throws_made / self.free_throws_attempted * 100, 1)
        return 0

    '''(Points + Rebounds + Assists + Steals + Blocks + Fouls Drawn)
        - (Missed Field Goals + Missed Free Throws + Turnovers + Shots Rejected + Fouls Committed)'''
    def getPerformanceIndexRating(self):
        return (self.getPoints() + self.getTotalRebounds() + self.assists \
            + self.steals + self.blocks_in_favor + self.fouls_received) - \
            (self.getMissedFieldGoals() + self.getMissedFreeThrows() + self.turnovers + \
            self.blocks_against + self.fouls_commited)

class Team:

    def __init__(self, name="", coach="", players=""):
        self.name = name
        self.coach = coach
        self.players = players
        self.tehnicals = 0
        self.firstQuarterPoints = 0;
        self.secondQuarterPoints = 0;
        self.thirdQuarterPoints = 0;
        self.fourthQuarterPoints = 0;
        self.overtimePoints = 0;

    def getPointsAfterSecond(self):
        return self.firstQuarterPoints + self.secondQuarterPoints

    def getPointsAfterThird(self):
        return self.getPointsAfterSecond() + self.thirdQuarterPoints

    def getPointsAfterFourth(self):
        return self.getPointsAfterThird() + self.fourthQuarterPoints

    def getPoints(self):
        points = 0
        for p in self.players:
            points += p.getPoints()
        return points

    def getFouls(self):
        fouls = self.tehnicals
        for p in self.players:
            fouls += p.fouls_commited
        return fouls

    def getTotalRebounds(self):
        rebounds = 0
        for p in self.players:
            rebounds += p.getTotalRebounds()
        return rebounds

    def getOffensiveRebounds(self):
        rebounds = 0
        for p in self.players:
            rebounds += p.rebounds_offensive
        return rebounds

    def getDefensiveRebounds(self):
        rebounds = 0
        for p in self.players:
            rebounds += p.rebounds_deffensive
        return rebounds

    def getAssists(self):
        assists = 0
        for p in self.players:
            assists += p.assists
        return assists

    def getSteals(self):
        steals = 0
        for p in self.players:
            steals += p.steals
        return steals

    def getBlocks(self):
        blocks = 0
        for p in self.players:
            blocks += p.blocks_in_favor
        return blocks

    def getTurnovers(self):
        turnovers = 0
        for p in self.players:
            turnovers += p.turnovers
        return turnovers

    def getPlayersPerformanceIndexRating(self):
        index = 0
        for p in self.players:
            index += p.getPerformanceIndexRating()
        return index

    def getFreeThrowsAttempted(self):
        val = 0
        for p in self.players:
            val += p.free_throws_attempted
        return val

    def getFreeThrowsMade(self):
        val = 0
        for p in self.players:
            val += p.free_throws_made
        return val

    def getTwoPointsAttempted(self):
        val = 0
        for p in self.players:
            val += p.two_points_attempted
        return val

    def getTwoPointsMade(self):
        val = 0
        for p in self.players:
            val += p.two_points_made
        return val

    def getThreePointsAttempted(self):
        val = 0
        for p in self.players:
            val += p.three_points_attempted
        return val

    def getThreePointsMade(self):
        val = 0
        for p in self.players:
            val += p.three_points_made
        return val

    def getFieldGoalsMade(self):
        val = 0
        for p in self.players:
            val += p.getFieldGoalsMade()
        return val

    def getFieldGoalsAttempted(self):
        val = 0
        for p in self.players:
            val += p.getFieldGoalsAttempted()
        return val

    def getFieldGoalsMA(self):
        return str(self.getFieldGoalsMade()) + '/' + str(self.getFieldGoalsAttempted())

    def getTwoPointsMA(self):
        return str(self.getTwoPointsMade()) + '/' + str(self.getTwoPointsAttempted())

    def getThreePointsMA(self):
        return str(self.getThreePointsMade()) + '/' + str(self.getThreePointsAttempted())

    def getFreeThrowsMA(self):
        return str(self.getFreeThrowsMade()) + '/' + str(self.getFreeThrowsAttempted())

    def getFieldGoalsPercentage(self):
        if self.getFieldGoalsAttempted() != 0:
            return round(self.getFieldGoalsMade() / self.getFieldGoalsAttempted() * 100, 1)
        else:
            return 0

    def getTwoPointsPercentage(self):
        if self.getTwoPointsAttempted() != 0:
            return round(self.getTwoPointsMade() / self.getTwoPointsAttempted() * 100, 1)
        else:
            return 0

    def getThreePointsPercentage(self):
        if self.getThreePointsAttempted() != 0:
            return round(self.getThreePointsMade() / self.getThreePointsAttempted() * 100, 1)
        else:
            return 0

    def getFreeThrowsPercentage(self):
        if self.getFreeThrowsAttempted() != 0:
            return round(self.getFreeThrowsMade() / self.getFreeThrowsAttempted() * 100, 1)
        else:
            return 0

class Event():

    def __init__(self, action, homePoints, awayPoints, team, player):
        self.action = action
        self.homePoints = homePoints
        self.awayPoints = awayPoints
        self.team = team
        self.player = player
