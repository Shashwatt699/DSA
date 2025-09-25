Fraction to Recurring Decimal

Problem Summary:
Given two integers representing the numerator and denominator of a fraction, return the fraction in string format.

If the fractional part is repeating, enclose the repeating part in parentheses.

Example:

1/2 → "0.5"

2/1 → "2"

4/333 → "0.(012)"

Core Concept & Approach:
This problem is about simulating the process of long division and detecting when decimals start to repeat. The key idea is to track remainders – the moment a remainder repeats, the corresponding decimals will also start repeating. We use a map to remember the position where each remainder occurred.

Step-by-Step Solution:

Sign Handling:

If the result is negative, add "-" at the start.

Integer Part:

Compute integer division (numerator / denominator
numerator/denominator) and add this to the result as the part before the decimal.

Fractional Part (if any):

If there’s a remainder, add a decimal point.

Now, to simulate decimal placement:

Multiply remainder by 10.

Record the position (length of result so far) of this remainder.

Append the resulting digit (
remainder
/
denominator
remainder/denominator) to the result.

Set remainder = remainder % denominator.

If a remainder repeats (seen earlier in map), then the decimal starts repeating from this position — insert '(' at that position and append ')' at the end.

Stop When:

Remainder becomes 0 (finite decimal)

Or a remainder repeats (infinite repeating decimal part)

---------------------------------------------------------------------------------------