package szabados.alpar.exercises

/* Add two numbers together */

class AddTwoNumbers {
    static addTwoNumbers(Number num1, Number num2) {
        def list1Reverse = num1.toString().toList().reverse()*.toInteger()
        def list2Reverse = num2.toString().toList().reverse()*.toInteger()

        def bigNum = list1Reverse
        def smallNum = list2Reverse

        if (list1Reverse.size() < list2Reverse.size()) {
            bigNum = list2Reverse
            smallNum = list1Reverse
        }

        def resultNumber = []
        def carry = 0
        for (int i in 0..<bigNum.size()) {
            int sum = sum(smallNum, bigNum, i)
            int result = (sum + carry).toString().toInteger() % 10
            resultNumber += result
            carry = ((sum + carry) - result) / 10
        }
        if (carry > 0)
            resultNumber += carry

        resultNumber.reverse().join()
    }
    static sum(List<Integer> smallNum, List<Integer> bigNum, int i) {
        (smallNum[i] != null) ? bigNum[i] + smallNum[i] : bigNum[i]
    }
}
