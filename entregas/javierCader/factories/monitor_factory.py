from models.monitor import Monitor

class MonitorFactory:
    def createMonitors(self, n, names):
        monitors = []
        for i in range(n):
            monitors.append(self.createMonitor(names[i]))
        return monitors

    def createMonitor(self, name):
        return Monitor(name)
