from collections import OrderedDict

class LRUCache:
    def __init__(self, capacity: int):
        self.cache = OrderedDict()
        self.capacity = capacity

    def access(self, key: str) -> None:
        if key in self.cache:
            self.cache.move_to_end(key)  # Mark the item as recently used
        else:
            if len(self.cache) >= self.capacity:
                self.cache.popitem(last=False)  # Remove the least recently used item
            self.cache[key] = None  # Insert the new item

    def get_cache(self) -> None:
        return list(self.cache.keys())

# Example usage:
cache = LRUCache(3)

cache.access("apple")
cache.access("banana")
cache.access("cherry")
print(cache.get_cache())  # Outputs: ['apple', 'banana', 'cherry']

cache.access("date")  # "apple" should be evicted
print(cache.get_cache())  # Outputs: ['banana', 'cherry', 'date']

cache.access("banana")  # "banana" is now the most recently used
cache.access("elderberry")  # "cherry" should be evicted
print(cache.get_cache())  # Outputs: ['date', 'banana', 'elderberry']
