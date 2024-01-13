The specific guarantees are as follows for numeric as in C/C++ it is dependent on compiler:

- char is at least 8 bits (1 byte by definition, however many bits it is)
- short is at least 16 bits
- int is at least 16 bits
- long is at least 32 bits
- long long (in versions of the language that support it) is at least 64 bits
- Each type in the above list is at least as wide as the previous type (but may well be the same).

-------------------

Float and doubles : 

Float is a 32-bit IEEE 754 single-precision floating-point number.

- Float can store the numbers between the range 3.4E-38 to 3.4E+38 i.e., from -3.4 x 1038   to +3.4 x 1038
- 1-bit for the sign, 8-bit for exponent, 23-bit for the value or mantissa
- The size of a float is 4-bytes(32 bit), i.e., a float variable requires 4-bytes of computer memory space.
- Float has 6-digits of precision which means we can use up to 6 digits after the decimal; otherwise, it will truncate anything after that. For example, 12.4356716 can be stored in a variable using float data type.

Double is a 64-bit IEEE 754 double-precision floating-point number.

- Double can store numbers between the range -1.7E+308 to +1.7E+308 i.e. from -1.7 x 10308   to +1.7 x 10308 
- 1-bit for the sign, 11-bit for exponent, 52-bit for the value of mantissa.
- Precision is the total number of digits (or significant digits) of a real number.
- The size of a double is 8-bytes(64 bit), i.e., a double variable requires 8-bytes of computer memory space.
- Double has 15-digits of precision which means the double variable is significant up to 15 decimal digits, and hence it will truncate anything after that.  For example, 12.435671123654328 can be stored in a variable using a double data type.
Also see, Ensemble Learning
