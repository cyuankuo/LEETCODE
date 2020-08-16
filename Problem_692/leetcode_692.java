// Given a non-empty list of words, return the k most frequent elements.

// Your answer should be sorted by frequency from highest to lowest. If two words have the same frequency, then the word with the lower alphabetical order comes first.

// Example 1:

// Input: ["i", "love", "leetcode", "i", "love", "coding"], k = 2
// Output: ["i", "love"]
// Explanation: "i" and "love" are the two most frequent words.
//     Note that "i" comes before "love" due to a lower alphabetical order.
// Example 2:

// Input: ["the", "day", "is", "sunny", "the", "the", "the", "sunny", "is", "is"], k = 4
// Output: ["the", "is", "sunny", "day"]
// Explanation: "the", "is", "sunny" and "day" are the four most frequent words,
//     with the number of occurrence being 4, 3, 2 and 1 respectively.

class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> map = new HashMap<>();
        int size = words.length;
        List<String> result = new ArrayList<>();
        for(int i = 0; i < size; i++) {
            map.put(words[i], map.getOrDefault(words[i], 0) + 1);
        }
        PriorityQueue<String> minHeap = new PriorityQueue<>((e1, e2) -> map.get(e1).equals(map.get(e2)) ? e2.compareTo(e1) :          
                                                            map.get(e1) - map.get(e2));
        map.forEach((key, value)-> {
                    minHeap.add(key);
                    if(minHeap.size() > k) {
                        minHeap.poll();
                    }
                    }
                   );
        // result.addAll(minHeap);
        while (!minHeap.isEmpty()) result.add(minHeap.poll());
        Collections.reverse(result);
        return result;
    }
}

