import math

def normal_round(n):
    # math.floor(n) + (1 - round(n - math.floor(n)))
    if n - math.floor(n) < 0.5:
        return math.floor(n)
    return math.ceil(n)

def binary_search(cards, query):
    upper = len(cards) - 1
    lower = 0
    middle = int(len(cards) / 2) if upper % 2 == 0 else normal_round(len(cards)/2)
    while middle >= 0 & middle < len(cards):
        if cards[middle] == query:
            return middle

        # If we have a list with length of 1 and the only element is not the one we're looking for
        elif upper == lower:
            return -1
        
        else:
            if cards[middle] < query:
                # move left
                upper = middle - 1
            elif cards[middle] > query:
                # move right
                lower = middle + 1
            new_length = upper - lower + 1
            dif = int(new_length / 2) if new_length % 2 == 0 else normal_round(new_length/2) - 1
            middle = lower + dif
    return -1


if __name__ == "__main__":
    tests = []

    # Query is in the middle
    tests.append({
        "input": {
            "cards": [13, 11, 10, 7, 4, 3, 1, 0],
            "query": 7
        },
        "output": 3,
        "name": "Query in middle"
    })

    # Query is somewhere between the middle and edge
    tests.append({
        "input": {
            "cards": [13, 11, 10, 7, 4, 3, 1, 0],
            "query": 1
        },
        "output": 6,
        "name": "Query between middle and edge"
    })

    # Query is the first element
    tests.append({
        "input": {
            "cards": [4, 2, 1, -1],
            "query": 4
        },
        "output": 0,
        "name": "Query first element"
    })

    # Query is the last element
    tests.append({
        "input": {
            "cards": [3, -1, -9, -127],
            "query": -127
        },
        "output": 3,
        "name": "Query last element"
    })

    # List contains just one element, the one we want
    tests.append({
        "input": {
            "cards": [6],
            "query": 6
        },
        "output": 0,
        "name": "List is one element"
    })

    # List does not contain query
    tests.append({
        "input": {
            "cards": [9, 7, 5, 2, -9],
            "query": 4
        },
        "output": -1,
        "name": "List does not contain query"
    })

    # List is empty
    tests.append({
        "input": {
            "cards": [],
            "query": 4
        },
        "output": -1,
        "name": "List is empty"
    })

    # Numbers repeat
    tests.append({
        "input": {
            "cards": [8, 8, 6, 6, 6, 6, 6, 3, 2, 2, 2, 0, 0, 0],
            "query": 3
        },
        "output": 7,
        "name": "List repeats numbers"
    })

    # Query occurs multiple times
    tests.append({
        "input": {
            "cards": [8, 8, 6, 6, 6, 6, 6, 5, 3, 2, 2, 2, 0, 0, 0],
            "query": 6
        },
        "output": 3,
        "name": "List repeats query"
    })

    for index, test in enumerate(tests):
        cards = test["input"]["cards"].copy()
        cards.sort(reverse=True)
        result = binary_search(cards, test["input"]["query"])

        expected_output = test["output"]
        name = test["name"]

        if result == test["output"]:
            print(f"Test {index}: '{name}' Pass")
        else:
            print(f"Test {index}: '{name}' Fail. Expected {expected_output}, got {result}")
