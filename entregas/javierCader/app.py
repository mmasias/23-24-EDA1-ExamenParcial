from main.ludoteca import Ludoteca
from factories.kid_factory import KidFactory
from factories.monitor_factory import MonitorFactory

class App:
    def __init__(self):
        self.ludoteca = Ludoteca()
        self.time = 0
        self.maxTime = 120 
        self.kidFactory = KidFactory()
        self.monitorFactory = MonitorFactory()

    def run(self):
        self.ludoteca.open()
        
        while self.ludoteca.is_open():
            self.manageKidsArrival()
            self.ludoteca.runGameIfPossible()
            self.time += 1
            
            if self.time > self.maxTime:
                self.ludoteca.close()

    def manageKidsArrival(self):
        kidsThatArrived = self.kidFactory.createKidsBasedOnTime(self.time)
        for kid in kidsThatArrived:
            self.ludoteca.manageKidsArrival(kid)

if __name__ == "__main__":
    app = App()
    app.run()
