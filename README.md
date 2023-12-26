This Java program utilizes the Reverse Polish Notation calculator approach and stores integers in Linked Lists as they may exceed memory constraints. The purpose of this program is to provide a calculator for astronomically large number calcuations.

The implementation uses a Stack data structure to store numbers and pushes/pops them upon encountering an operation, handled by the parser. The result is then pushed onto the stack, as the process continues until the parser has finished and there is only one number left on the stack which is the result.

For example,
`7 2 *` would return `14`, and
`12398 12039 * 1293 -` would return `149258229` and so on as the numbers grow larger.
