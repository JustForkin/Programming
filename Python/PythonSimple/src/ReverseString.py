'''
Created on May 11, 2011

@author: Michael
'''

#Reverses a String uses Slices
def rev1():
    myInput = raw_input("Enter a String to be reversed: ")
    return(myInput[::-1])
        
print(rev1())

#Reverses a String using substrings and a loop
def rev2():
    newInput = ""
    myInput = raw_input("Enter a String to be reversed: ")
    for x in range (0, len(myInput), 1):
        newInput = newInput + myInput[(len(myInput)-1):len(myInput)]
        myInput = myInput[0:len(myInput)-1]
    return(newInput)
        
print(rev2())
