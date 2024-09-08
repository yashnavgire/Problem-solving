1. To identify if 2 positions in a Grid are in a diagonal -
abs(col2-col1) == abs(row2-row1)

2. Array max size - 
- Global array : 10^8 (heap)
- Local array : 10^6 (stack)

3. Rolling hash can be used for dp states (for some questions)

4. In any dp problem, whenever we are deleting an item to move to next state, 
look for what is causing to delete an item to move to next state. This will help to model the state transitions 
