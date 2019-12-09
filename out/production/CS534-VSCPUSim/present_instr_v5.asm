// state = state xor rk
0: XOR 3 8
1: XOR 2 7
2: XOR 1 6
3: XOR 0 5

// jump halt if (counter == 32*4)
4: CP 9 12
5: ADD 9 15
6: BZJ 14 9

// key schedule start
// key = key xor round_counter
7: ADD 12 13
8: XOR 6 12

// key = key r>> 3  
// 9: GETW 9 0   // zeroize W
9: CP 9 4  // save key_0
10: SRLi 9 3
11: SRLi 8 3
12: SRLi 7 3
13: SRLi 6 3
14: SRLi 5 3
15: SRLi 4 3

// key = key r>> 16 
16: CP 9 4
17: CP 4 5
18: CP 5 6
19: CP 6 7
20: CP 7 8
21: CP 8 9

// key = SBOX(key[79:76]) & key
22: SBOX 8 0
// key schedule end

// encrypt - SBox
23: SBOX 3 1
24: SBOX 2 1
25: SBOX 1 1
26: SBOX 0 1

// encrypt - PLayer
// 28: GETW 9 0
27: PER3 1 0
28: PER3 3 2
29: GETW 11 1
30: PER2 1 0
31: PER2 3 2
32: GETW 10 1
33: PER1 1 0
34: PER1 3 2
35: GETW 9 1
36: PER0 1 0
37: PER0 3 2
38: GETW 0 1
// 38: GETW 9 1
// 39: CP 0 9
39: CP 1 9
40: CP 2 10
41: CP 3 11

// jump to the begining for 32 rounds
42: GETW 9 0
43: GETW 9 1
44: BZJi 9 0

// REMOVED
// Goto $HALT -- Instruction jumps to itself to terminate the process.
// 46: BZJi 16 14