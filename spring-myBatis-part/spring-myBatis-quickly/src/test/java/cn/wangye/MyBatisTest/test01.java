package cn.wangye.MyBatisTest;

import cn.wangye.mapper.EmployeeMapper;
import cn.wangye.pojo.Employee;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.Comparator;

public class test01 {
    @Test
    public void testSelectEmployee() throws IOException {

//        1.创建SqlSessionFactory对象
//        1.1 声明Mybatis全局配置文件的路径
        String mybatisConfigFilePath = "mybatis-config.xml";
//        1.2以输入流的形式加载Mybatis配置文件
        InputStream inputStream = Resources.getResourceAsStream(mybatisConfigFilePath);
//        1.3基于读取Mybatis配置输入流创建SqlSessionFactory对象
        SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

//       2.使用SqlSessionFactory对象开启一个会话
        SqlSession session = sessionFactory.openSession();

//        3.根据EmployeeMapper接口的Class对象获取Mapper接口类型的对象（动态代理技术）
        EmployeeMapper employeeMapper = session.getMapper(EmployeeMapper.class);
//        4.调用代理类方法触发对应的SQL语句
        Employee employee = employeeMapper.selectEmployee(1);
        System.out.println(employee);
//        5.关闭SqlSession
        session.commit();
        session.close();
    }


    @Test
    public String PrintMinNumber(int[] numbers) {
        if (numbers == null || numbers.length == 0) {
            return "";
        }
        String[] array = new String[numbers.length];
        for (int i = 0; i < array.length; i++) {
            array[i] = String.valueOf(numbers[i]);
        }
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length - i - 1; j++) {
                String str1 = array[j] + array[j + 1];
                String str2 = array[j + 1] + array[j];
                if (Integer.parseInt(str1) > Integer.parseInt(str2)) {

                }
            }
        }

        return null;
    }


//    二元选择排序，一次循环查找最大值和最小值;
    @Test
    public void selectedSort(int [] arr){
        for (int i = 0; i < arr.length/2; i++) {//二元选择排序，我们只需要遍历数组的一般即可，不需要进行完全遍历;
            int minIndex = i;
            int maxIndex = i;
            for (int j = i+1; j < arr.length-i; j++) {
                if (arr[minIndex]>arr[j]){
                    minIndex = j;
                }
                if (arr[maxIndex]<arr[j]){
                    maxIndex = j;
                }
            }
//            遍历数组之后,对我们获取到的最大值、最小值进行排序交换;
            if (minIndex==maxIndex) break;
//            进行最小值的交换:
            int temp = arr[i];
            arr[i] = arr[minIndex];
            arr[minIndex] = temp;
//            如果maxIndex == i,由于我们之前最小值已经发生了交换，所以这里需要最maxIndex值进行更新;
            if (maxIndex == i) maxIndex = minIndex;
            // 进行最大值的交换
            temp = arr[arr.length-i-1];
            arr[arr.length-i-1] = arr[maxIndex];
            arr[maxIndex] = temp;
        }
    }


    public static void selectionSort2(int[] arr) {
        int minIndex, maxIndex;
        // i 只需要遍历一半
        for (int i = 0; i < arr.length / 2; i++) {
            minIndex = i;
            maxIndex = i;
            for (int j = i + 1; j < arr.length - i; j++) {
                if (arr[minIndex] > arr[j]) {
                    // 记录最小值的下标
                    minIndex = j;
                }
                if (arr[maxIndex] < arr[j]) {
                    // 记录最大值的下标
                    maxIndex = j;
                }
            }
            // 如果 minIndex 和 maxIndex 都相等，那么他们必定都等于 i，且后面的所有数字都与 arr[i] 相等，此时已经排序完成
            if (minIndex == maxIndex) break;
            // 将最小元素交换至首位
            int temp = arr[i];
            arr[i] = arr[minIndex];
            arr[minIndex] = temp;
            // 如果最大值的下标刚好是 i，由于 arr[i] 和 arr[minIndex] 已经交换了，所以这里要更新 maxIndex 的值。
            if (maxIndex == i) maxIndex = minIndex;
            // 将最大元素交换至末尾
            int lastIndex = arr.length - 1 - i;
            temp = arr[lastIndex];
            arr[lastIndex] = arr[maxIndex];
            arr[maxIndex] = temp;
        }
    }
}

















































