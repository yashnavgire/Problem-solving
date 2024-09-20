### Intuition

1. move sweep line from left to right on sorted intervals(most of the time) and greedily solve by 
inferring the state b/w 2 events.
2. Identify what will be the events too for a question


### Problem it solves

1. sweep line used on interval problems to process the time series events efficiently
2. In b/w 2 consecutive events the state of what we are processing is constant, 
so we need not to process the points b/w 2 consecutive events which would be redundant. 
