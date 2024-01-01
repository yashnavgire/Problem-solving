Comparator<Node> comp = new Comparator<>() {
            
            @Override
            public int compare(Node a, Node b) {
                if (a.val > b.val) {
                    return -1;
                } else if (b.val > a.val) {
                    return 1;
                } else {
                    return 0;
                }
            }
        };
