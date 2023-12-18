# Problem Set 4A
# Name: <your name here>
# Collaborators:
# Time Spent: x:xx

import random

def factorial(n):
    fact = 1
    for num in range(2, n + 1):
        fact *= num
    return fact

def get_permutations(sequence):
    '''
    Enumerate all permutations of a given string

    sequence (string): an arbitrary string to permute. Assume that it is a
    non-empty string.  

    You MUST use recursion for this part. Non-recursive solutions will not be
    accepted.

    Returns: a list of all permutations of sequence

    Example:
    >>> get_permutations('abc')
    ['abc', 'acb', 'bac', 'bca', 'cab', 'cba']

    Note: depending on your implementation, you may return the permutations in
    a different order than what is listed here.
    '''
    out = []
    if len(sequence) == 1:
        return sequence
    else:
        for i,j in enumerate(sequence):
            for perm in get_permutations(sequence[:i] + sequence[i+1:]):
                out += [j + perm]
    return out
    
if __name__ == '__main__':
#    #EXAMPLE
#    example_input = 'abc'
#    print('Input:', example_input)
#    print('Expected Output:', ['abc', 'acb', 'bac', 'bca', 'cab', 'cba'])
#    print('Actual Output:', get_permutations(example_input))
    
#    # Put three example test cases here (for your sanity, limit your inputs
#    to be three characters or fewer as you will have n! permutations for a 
#    sequence of length n)
     print('Input:', 'abc')
     print('Expected Output:', ['abc', 'acb', 'bac', 'bca', 'cab', 'cba'])
     print('Actual Output:', get_permutations('abc'))
     print('Passed:', ['abc', 'acb', 'bac', 'bca', 'cab', 'cba'] == get_permutations('abc'))

     print('Input:', 'xyz')
     print('Expected Output:', ['xyz', 'xzy', 'yxz', 'yzx', 'zxy', 'zyx'])
     print('Actual Output:', get_permutations('xyz'))
     print('Passed:', ['xyz', 'xzy', 'yxz', 'yzx', 'zxy', 'zyx'] == get_permutations('xyz'))

     print('Input:', 'qr')
     print('Expected Output:', ['qr', 'rq'])
     print('Actual Output:', get_permutations('qr'))
     print('Passed:', ['qr','rq'] == get_permutations('qr'))

    

