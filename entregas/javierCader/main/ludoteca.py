from datastructures.queue import Queue
from models.monitor import Monitor
from models.kid import Kid
from main.game import Game

class Ludoteca:
    def __init__(self):
        self.isOpen = False
        self.monitors = [Monitor("Lydia"), Monitor("Aisha")]
        self.game = Game()

    def open(self):
        self.isOpen = True

    def close(self):
        self.isOpen = False
        
    def is_open(self):
        return self.isOpen

    def manageKidsArrival(self, kid):
        if not self.isOpen:
            return
        self.monitors[0].receiveAndOrganizeKids(kid) 

    def runGameIfPossible(self):
        if not self.isOpen:
            return

        self.monitors[1].manageGame(self.game, self.monitors[0].queue)  

        if self.game.isRunning and self.monitors[1].queue.is_empty() and self.monitors[0].queue.is_empty():
            self.endGame()

    def endGame(self):
        finalMessage = self.game.endGame()
        self.monitors[1].receiveFinalMessage(finalMessage)
        self.monitors[1].readFinalMessage()