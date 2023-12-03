from data_structures.queue import Queue
from models.monitor import Monitor
from models.kid import Kid
from main.game import Game

class Ludoteca:
    def __init__(self):
        self.isOpen = False
        self.monitors = None
        self.game = Game()

    def open(self):
        self.isOpen = True

    def close(self):
        self.isOpen = False
        
    def is_open(self):
        return self.isOpen
    
    def employMonitors(self, monitors):
        print(f"Monitors employed: {', '.join(monitor.name for monitor in monitors)}")
        self.monitors = monitors


    def manageKidsArrival(self, kid):
        assert self.monitors is not None, "No monitors employed"
        assert self.isOpen, "Ludoteca not open"
        
        self.monitors[0].receiveAndOrganizeKids(kid) 

    def doWork(self):
        assert self.monitors is not None, "No monitors employed"
        assert self.isOpen, "Ludoteca not open"
            
        self.monitors[0].passKidsToNextMonitor(self.monitors[1])

        self.monitors[1].manageGame(self.game)  

        if self.game.isRunning and self.monitors[1].queue.is_empty() and self.monitors[0].queue.is_empty():
            self.endGame()

    def endGame(self):
        finalMessage = self.game.endGame()
        self.monitors[1].receiveFinalMessage(finalMessage)
        self.monitors[1].readFinalMessage()