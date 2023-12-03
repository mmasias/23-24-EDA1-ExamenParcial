import random
from models.kid import Kid

class KidFactory:
    def createKidsBasedOnTime(self, time):
        kids = []

        if time < 10: 
            kidsCount = random.randint(0, 2) 
            for _ in range(kidsCount):
                kids.append(Kid())

        elif 10 <= time < 30: 
            if time % 3 == 0: 
                if random.choice([True, False]):
                    kids.append(Kid())
                    
        print(f"{len(kids)} kid(s) arrived!")

        return kids
