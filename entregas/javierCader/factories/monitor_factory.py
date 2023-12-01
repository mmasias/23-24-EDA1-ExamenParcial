from models.monitor import Monitor

class MonitorFactory:
    def createMonitors(self):
        return [Monitor("Aisha"), Monitor("Lidia")]