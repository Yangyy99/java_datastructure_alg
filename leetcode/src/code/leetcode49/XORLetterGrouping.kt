package code.leetcode49

import java.util.*
import kotlin.collections.ArrayList
import kotlin.collections.HashMap
import kotlin.math.pow

/**
 * @Author: 云萧YYY
 * @DateTime: 2022/01/19
 * @Description: TODO leetcode 49
 * 给你一个字符串数组，请你将 字母异位词 组合在一起。可以按任意顺序返回结果列表。
 *字母异位词 是由重新排列源单词的字母得到的一个新单词，所有源单词中的字母通常恰好只用一次。
 */
fun main() {
    /**
     * in: ["eat", "tea", "tan", "ate", "nat", "bat"]
     * out:[["bat"],["nat","tan"],["ate","eat","tea"]]
     */
    val letterSort = countChar("eat")
    print(letterSort)
}


/**
 * 排序法
 */
fun groupAnagrams(strs: Array<String>): List<List<String>>? {

    val map = HashMap<String, ArrayList<String>>(16);
    strs.forEach {
        //对字符串进行排序,相同字母的单词 排序完之后一定是相同的
        map.computeIfAbsent(letterSort(it)) {
            ArrayList<String>()
        }.add(it)

    }
    return map.values.toList()
}

/**
 * hash 法
 */
fun groupAnagramsToHash(strs: Array<String>): List<List<String>>? {
    val map = HashMap<String, ArrayList<String>>(16)
    strs.forEach {
        map.computeIfAbsent(countChar(it)) {
            ArrayList()
        }.add(it)
    }
    return map.values.toList()
}

/**
 * 统计一个单词出现的频次并以字符串的方式返回
 */
fun countChar(letter: String): String {

    val count = IntArray(26)
    letter.forEach {
        count[it.code - 97]++
    }
    return transferToString(count)
}

/**
 * 传入一个计数数组
 * 返回一个 1#2#0...... 的字符串
 */
fun transferToString(array: IntArray): String {

    var result = ""
    array.forEach {
        result += "$it#"
    }
    return result
}


/**
 * 对str中每个字符进行排序
 */
fun letterSort(letter: String): String {
    return letter.toCharArray().apply(CharArray::sort).contentToString()
}


