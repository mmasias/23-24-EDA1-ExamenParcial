import random
from models.kid import Kid

class KidFactory:
    def createKidsBasedOnTime(self, time):
        kids = []
        kidsCount = random.randint(0, 2) if time < 10 else 0
        for _ in range(kidsCount):
            kids.append(Kid())
        return kids
