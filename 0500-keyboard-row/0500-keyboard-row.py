class Solution:
    def findWords(self, words: list[str]) -> list[str]:
        keyboard = ["qwertyuiop", "asdfghjkl", "zxcvbnm"]
        ans = []

        for i in range(len(words)):
            s = words[i].lower()

            for j in range(len(keyboard)):
                flag = True 

                for z in range(len(s)):
                    if s[z] not in keyboard[j]:
                        flag = False
                        break

                if flag:
                    ans.append(words[i])
                    break

        return ans
