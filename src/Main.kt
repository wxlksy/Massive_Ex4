fun main()
{
    println("Введите первый массив:")
    val arr1 = readLine()?.split(" ")?.map { it.toInt() } ?: emptyList()

    println("Введите второй массив:")
    val arr2 = readLine()?.split(" ")?.map { it.toInt() } ?: emptyList()

    val intersection = findIntersection(arr1, arr2)
    println("Пересечение: ${intersection.joinToString(" ")}")
}

fun findIntersection(array1: List<Int>, array2: List<Int>): List<Int>
{
    val countM1 = mutableMapOf<Int, Int>()
    val countM2 = mutableMapOf<Int, Int>()

    for (s in array1)
    {
        countM1[s] = countM1.getOrDefault(s, 0) + 1
    }

    for (s in array2)
    {
        countM2[s] = countM2.getOrDefault(s, 0) + 1
    }

    val sect = mutableListOf<Int>()

    for ((num, count1) in countM1)
    {
        val count2 = countM2[num] ?: 0
        val min = minOf(count1, count2)
        for (i in 0 until min)
        {
            sect.add(num)
        }
    }

    return sect
}