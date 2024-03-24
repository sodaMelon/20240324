def count_coin_combinations(sum, coins):
    memo = {}

    def count_combinations_recursive(target_sum, index):
        # caseA: target_sum이 0이 되면 하나의 유효한 조합이 완성됨
        if target_sum == 0:
            return 1
        # caseB: target_sum이 음수가 되면 유효한 조합이 아님
        if target_sum < 0:
            return 0
        # caseC: 모든 동전을 사용한 경우
        if index == len(coins):
            return 0

        # memo: 이미 계산한 값이라면 그 값을 반환
        if (target_sum, index) in memo:
            return memo[(target_sum, index)]

        # 현재 동전을 사용하는 경우와 사용하지 않는 경우를 모두 고려
        count = (count_combinations_recursive(target_sum - coins[index], index) +
                 count_combinations_recursive(target_sum, index + 1))

        # 계산 결과를 memo에 저장
        memo[(target_sum, index)] = count

        return count

    return count_combinations_recursive(sum, 0)

# 예시 입력
sum = 4
coins = [1,2,3,]
print(count_coin_combinations(sum, coins))