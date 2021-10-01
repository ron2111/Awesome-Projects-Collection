def swap_case(s):
    result = ""
    for idx in xrange(len(s)):
        ordinal = ord(s[idx])
        if (ordinal >= ord('a') and ordinal <= ord('z')) or \
            (ordinal >= ord('A') and ordinal <= ord('Z')):
            result += chr(ordinal-ord('A')+32)%64+ord('A'))
        else:
            result += s[idx]
    return result
