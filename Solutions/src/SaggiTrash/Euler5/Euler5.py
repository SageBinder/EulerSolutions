i = 20
found = False
while not found:
    print(i)
    for divisor in range(1, 21):
        if i % divisor > 0:
            break
    else:
        print(i)
        found = True
    i = i + 1
