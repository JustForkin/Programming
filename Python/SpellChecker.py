'''
Created on May 11, 2011

@author: Michael
'''

class SpellChecker:
    #Reads in a list of words from Dictionary.txt and "spell-checks" user-inputted words
    def spellCheck(self):
        myFile = open("Dictionary", 'r')
        wordList = myFile.readlines()
        for i in range(0, len(wordList), 1):
            wordList[i] = wordList[i].strip()
        
        while True:
            correct = False
            myWord = raw_input("Enter a word to check its spelling: (Press '0' to quit) ")
            if(myWord == '0'):
                break
            for currentWord in wordList:
                if(myWord == currentWord):
                    print("You spelled " + '\"' + myWord + '\"' + " correctly!")  
                    correct = True
            if(correct == False):
                print("Sorry, " + '\"' + myWord + '\"' + " is spelled incorrectly.")  
            print("\r")
        myFile.close()  
  
myChecker = SpellChecker()       
myChecker.spellCheck()
