class Game:
    def __init__(self):
        self.gameMessage = ""
        self.kidsQueue = None
        self.isRunning = False

    def startGame(self, initialMessage, queue):
        self._setMessage(initialMessage)
        self.kidsQueue = queue
        self.isRunning = True
        print(f"Game started with message: {initialMessage}")

    def continueGame(self):
        if self.kidsQueue.is_empty():
            return

        kid = self.kidsQueue.dequeue()
        kid.receiveMessage(self.gameMessage) 
        currentMessage = kid.showMessage()
        self._setMessage(currentMessage) 
        
    def _setMessage(self, message):
        self.gameMessage = message

    def endGame(self):
        self.isRunning = False
        return self.gameMessage