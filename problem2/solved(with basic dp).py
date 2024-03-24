def count_coin_combinations(sum, coins):
    dp = [0] * (sum + 1)
    dp[0] = 1

    coins.sort()  # 동전의 가치를 오름차순으로 정렬

    for coin in coins:
        for i in range(coin, sum + 1):
            dp[i] += dp[i - coin]

    return dp[sum]

# 예시 입력
sum = 10
coins = [2, 5, 3, 6]
print(count_coin_combinations(sum, coins))
