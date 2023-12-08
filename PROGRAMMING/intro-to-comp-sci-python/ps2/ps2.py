'''
1. The computer must select a word at random from the list of available words
that was provided in words.txt
Note that words.txt contains words in all lowercase letters.
2. The user is given a certain number of guesses at the beginning.
3. The game is interactive; the user inputs their guess and the computer either:
a. reveals the letter if it exists in the secret word
b. penalize the user and updates the number of guesses remaining
4. The game ends when either the user guesses the secret word, or the user runs
out of guesses.
'''

import random
import string
import hangman

# load words and select random

def getWord():
    f = open("words.txt", "r")
    words = f.read().split(" ")
    randomWord = random.choice(words)
    #print(randomWord)
    return randomWord

def is_word_guessed(secret_word, letters_guessed):
    isGuessed = True
    for i in secret_word:
        if i not in letters_guessed:
            isGuessed = False
            break
    return isGuessed 

def get_guessed_word(secret_word, letters_guessed):
    letters = secret_word.split()
    guessed = []
    for i in secret_word:
        if i in letters_guessed:
            guessed.append(i)
        else:
            guessed.append(' _ ')
    return "".join(guessed)

def get_available_letters(letters_guessed):
    lower_case = string.ascii_lowercase
    for i in letters_guessed:
        lower_case = lower_case.replace(i,'')
    return lower_case
 
letters_guessed = []

def main(guesses, warnings, word):
    print("Welcome to the game Hangman!")
    print("I am thinking of a word that is " + str(len(word)) + " letters long.")
    print("----------------")
    while guesses > 0:
        guess = input("Guess a letter: ")
        if not guess.isalpha():
            warnings = warnings - 1
            if warnings > 0:
                print("Oops! That is not a valid letter. You have " + str(warnings) + " warnings left:"  + get_guessed_word(word, letters_guessed))
            else:
                print("Oops! That is not a valid letter. You are out of warnings.")
                break
        else:
            letters_guessed.append(guess)
            guesses=guesses-1
            if guess in word:
                print("'" + guess + "' is in the word: " + get_guessed_word(word, letters_guessed))
            else:
                print("Oops! The letter '" + guess + "' is not in the word: " + get_guessed_word(word, letters_guessed))
            if is_word_guessed(word, letters_guessed):
                print("Congratulations!")
                break
            else:
                if guesses < 1:
                    print("You're out of guesses. The word is " + word)
                    print("")
                    break
                print("")
                print("You have " + str(guesses) + " guesses left.")
                print("Available letters: " + get_available_letters(letters_guessed))
                print("----------------")

if __name__ == "__main__":
    main(6, 3, getWord())