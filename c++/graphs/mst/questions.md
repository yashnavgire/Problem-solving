#### Max spanning tree
sort/process edges in descending order (instead of ascending)

#### Find MST with edge having a cost and node having cost too.
- we want to somehow represent the node cost as edge cost so that we can apply MST on it.
- therefore we introduce a `super node` to which all node connect with cost of the edge equal to cost of that node. this transfers the cost from node to edge representation
- now we can run normal mst