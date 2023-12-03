class Board:
    def __init__(self):
        self.message = ""

    def receiveMessage(self, message):
        self.message = message
    
    def cleanMessage(self):
        self.message = ""