package com.allan.Util;

import org.apache.commons.lang3.StringUtils;

import java.text.DateFormat;
import java.text.Format;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * 时间工具类
 *
 *
 * @author qinzz
 */
public class DateUtil {
	/**
	 * 获取本周的截止时间
	 * 
	 * @return
	 */
	public static Date getWeekendTime() {
		int mondayPlus = getMondayPlus();
		GregorianCalendar currentDate = new GregorianCalendar();
		currentDate.add(GregorianCalendar.DATE, mondayPlus + 6);
		currentDate.set(currentDate.get(Calendar.YEAR), currentDate.get(Calendar.MONTH), currentDate.get(Calendar.DATE), 23, 59, 59);
		return currentDate.getTime();
	}
	
	/**
	 * 获取本周的起始时间
	 * 
	 * @return
	 */
	public static Date getWeekstartTime() {
		Calendar now = Calendar.getInstance();
		int weekDay = now.get(Calendar.DAY_OF_WEEK) == 1 ? 8 : now.get(Calendar.DAY_OF_WEEK);
		now.add(Calendar.DATE, Calendar.MONDAY - weekDay);
		now.set(now.get(Calendar.YEAR), now.get(Calendar.MONTH), now.get(Calendar.DATE), 0, 0, 0);
		return now.getTime();
	}
	
	/**
	 * 获取本日的起始时间
	 * 
	 * @return
	 */
	public static Date getTodayStartTime() {
		Calendar now = Calendar.getInstance();
		now.set(now.get(Calendar.YEAR), now.get(Calendar.MONTH), now.get(Calendar.DATE), 0, 0, 0);
		return now.getTime();
	}
	
	/**
	 * 获取本日的截止时间
	 * 
	 * @return
	 */
	public static Date getTodayEndTime() {
		Calendar now = Calendar.getInstance();
		now.set(now.get(Calendar.YEAR), now.get(Calendar.MONTH), now.get(Calendar.DATE), 23, 59, 59);
		return now.getTime();
	}
	/**
	 * 设置时间到最后一秒钟
	 * @author zhaolei
	 * @date 2015年11月6日
	 * @param time
	 * @return
	 */
	public static Date getDateEndTime(Date time){
		Calendar now=Calendar.getInstance();
		now.setTime(time);
		int year=now.get(Calendar.YEAR);
		int month=now.get(Calendar.MONTH);
		int date=now.get(Calendar.DAY_OF_MONTH);		
		now.set(year, month, date, 23, 59, 59);
		return now.getTime();
	}
	/**
	 * 获取本月的起始时间
	 * 
	 * @return
	 */
	public static Date getMonthstartTime() {
		Calendar now = Calendar.getInstance();
		now.set(now.get(Calendar.YEAR), now.get(Calendar.MONTH), 1, 0, 0, 0);
		return now.getTime();
	}
	
	/**
	 * 获取本月的截止时间
	 * 
	 * @return
	 */
	public static Date getMonendTime() {
		Calendar lastDate = Calendar.getInstance();
		lastDate.set(Calendar.DATE, 1);// 设为当前月的1号
		lastDate.add(Calendar.MONTH, 1);// 加一个月，变为下月的1号
		lastDate.add(Calendar.DATE, -1);// 减去一天，变为当月最后一天
		lastDate.set(lastDate.get(Calendar.YEAR), lastDate.get(Calendar.MONTH), lastDate.get(Calendar.DATE), 23, 59, 59);
		return lastDate.getTime();
	}
	/**
	 * 获取指定时间的截止时间
	 * 
	 * @return
	 */
	public static Date getMonendTime(Date date) {
		Calendar lastDate = Calendar.getInstance();
		lastDate.setTime(date);
		lastDate.set(Calendar.DATE, 1);// 设为当前月的1号
		lastDate.add(Calendar.MONTH, 1);// 加一个月，变为下月的1号
		lastDate.add(Calendar.DATE, -1);// 减去一天，变为当月最后一天
		lastDate.set(lastDate.get(Calendar.YEAR), lastDate.get(Calendar.MONTH), lastDate.get(Calendar.DATE), 23, 59, 59);
		return lastDate.getTime();
	}
	/**
	 * 格式化时间
	 * 
	 * @return
	 */
	public static String format(Date dt) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return sdf.format(dt);
	}
	
	/**
	 * 格式化时间
	 * 
	 * @return
	 */
	public static String format(Date dt, String pattern) {
		SimpleDateFormat sdf = new SimpleDateFormat(pattern);
		return sdf.format(dt);
	}
	
	/**
	 * 将字符串转换成日期
	 * 
	 * @return
	 */
	public static Date parse(String dt) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		try {
			return sdf.parse(dt);
		}
		catch (ParseException e) {
			return null;
		}
	}
	
	/**
	 * 将字符串转换成日期
	 * 
	 * @return
	 */
	public static Date parse(String dt, String fmt) {
		SimpleDateFormat sdf = new SimpleDateFormat(fmt);
		try {
			return sdf.parse(dt);
		}
		catch (ParseException e) {
			return null;
		}
	}
	
	// 获得当前日期与本周日相差的天数
	private static int getMondayPlus() {
		Calendar cd = Calendar.getInstance();
		// 获得今天是一周的第几天，星期日是第一天，星期二是第二天......
		int dayOfWeek = cd.get(Calendar.DAY_OF_WEEK) - 1; // 因为按中国礼拜一作为第一天所以这里减1
		if (dayOfWeek == 1) {
			return 0;
		}
		else {
			return 1 - dayOfWeek;
		}
	}
	/**
	 * 获取给定时间返回的星期
	 * @param date
	 * @return
	 */
	public static String getWeek(Date date) {
		Calendar cd = Calendar.getInstance();
		cd.setTime(date);
		Format f = new SimpleDateFormat("E");
		return f.format(cd.getTime());
	}
	public static String formatDate(Calendar paramCalendar) {
		SimpleDateFormat localSimpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return localSimpleDateFormat.format(paramCalendar.getTime());
	}
	
	public static String formatDateToString(Date paramDate) throws Exception {
		String str = null;
		if (paramDate == null)
			return "";
		SimpleDateFormat localSimpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		str = localSimpleDateFormat.format(paramDate);
		return str;
	}
	
	public static String formatDateToString2(Date paramDate) throws Exception {
		String str = null;
		if (paramDate == null)
			return "";
		SimpleDateFormat localSimpleDateFormat = new SimpleDateFormat("HHyyyymmddMMss");
		str = localSimpleDateFormat.format(paramDate);
		return str;
	}
	
	public static String formatDateToHour(Date paramDate) throws Exception {
		String str = null;
		if (paramDate == null)
			return "";
		SimpleDateFormat localSimpleDateFormat = new SimpleDateFormat("HH");
		str = localSimpleDateFormat.format(paramDate);
		return str;
	}
	
	public static String formatDateToStringNoTime(Date paramDate) throws Exception {
		String str = null;
		if (paramDate == null)
			return "";
		SimpleDateFormat localSimpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
		str = localSimpleDateFormat.format(paramDate);
		return str;
	}
	
	public static String formateDateToChinese(Calendar paramCalendar) {
		try {
			SimpleDateFormat localSimpleDateFormat = new SimpleDateFormat("yyyy年MM月dd日");
			return localSimpleDateFormat.format(paramCalendar.getTime());
		}
		catch (Exception localException) {
		}
		return "";
	}
	
	public static String formateDateToChineseWK(Calendar paramCalendar) {
		SimpleDateFormat localSimpleDateFormat = new SimpleDateFormat("yyyy年MM月dd日 EE");
		return localSimpleDateFormat.format(paramCalendar.getTime());
	}
	
	public static String formateDateToNumber(Calendar paramCalendar) {
		SimpleDateFormat localSimpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
		return localSimpleDateFormat.format(paramCalendar.getTime());
	}
	
	public static Calendar paserStringToCalendar(String paramString) {
		Calendar localCalendar = Calendar.getInstance();
		try {
			SimpleDateFormat localSimpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
			Date localDate = null;
			localDate = localSimpleDateFormat.parse(paramString);
			localCalendar.setTime(localDate);
		}
		catch (Exception localException) {
			return null;
		}
		return localCalendar;
	}
	
	public static Date parseFromString(String paramString) {
		SimpleDateFormat localSimpleDateFormat = new SimpleDateFormat();
		try {
			return localSimpleDateFormat.parse(paramString);
		}
		catch (ParseException localParseException) {
		}
		return null;
	}
	
	/**
	 * 计算第几年
	 */
	public static int getYears(Date startDate) {
		Date now = new Date();
		Calendar fromCalendar = Calendar.getInstance();
		fromCalendar.setTime(startDate);
		fromCalendar.set(Calendar.HOUR_OF_DAY, 0);
		fromCalendar.set(Calendar.MINUTE, 0);
		fromCalendar.set(Calendar.SECOND, 0);
		fromCalendar.set(Calendar.MILLISECOND, 0);
		
		Calendar toCalendar = Calendar.getInstance();
		toCalendar.setTime(now);
		toCalendar.set(Calendar.HOUR_OF_DAY, 0);
		toCalendar.set(Calendar.MINUTE, 0);
		toCalendar.set(Calendar.SECOND, 0);
		toCalendar.set(Calendar.MILLISECOND, 0);
		long ys = (toCalendar.getTime().getTime() - fromCalendar.getTime().getTime()) / (1000 * 60 * 60 * 24) / 365;
		return (int) (ys + 1);
	}
	
	/**
	 * 取得当前时间的字符串格式 pattern为格式 yyyy-MM-dd hh:mm:ss yyyy-MM-dd
	 */
	public static String getDateNow(String pattern) {
		return format(new Date(), pattern);
	}
	
	/**
	 * 
	 * @param date1
	 * @description 与当前系统时间比较大小，如果比当前时间大，则返回true，否则返回false
	 * @author
	 * @todo
	 */
	public static boolean compareDateNow(Date date1) {
		return compareDate(date1, new Date());
	}
	
	/**
	 * 
	 * @param date1
	 * @param date2
	 * @return
	 * @description 比较时间大小 ，如果date1比date2大，则返回true，否则返回false
	 * @author
	 * @todo
	 */
	public static boolean compareDate(Date date1, Date date2) {
		if (date1 == null) {
			return false;
		}
		if (date2 == null) {
			return true;
		}
		return compareDate(format(date1), format(date2));
	}
	
	/**
	 * 
	 * @param date1
	 * @param date2
	 * @return 比较时间大小 ，如果date1比date2大，则返回true，否则返回false
	 * @description
	 * @author
	 * @todo
	 */
	public static boolean compareDate(String date1, String date2) {
		boolean result = false;
		
		if (date1 == null) {
			return false;
		}
		if (date2 == null) {
			return true;
		}
		
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			/*System.out.println("date1:"+sdf.parse(date1).getTime());
			System.out.println("date2:"+sdf.parse(date2).getTime());
			System.out.println("date1:"+date1);
			System.out.println("date2:"+date2);*/
			if (sdf.parse(date1).getTime() > sdf.parse(date2).getTime()) {
				result = true;
			}
		}
		catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return result;
	}
	/**
	 * 判断时间date3 是否在date1 与 date2 之间
	 * @param date1
	 * @param date2
	 * @param date3
	 * @return
	 */
	public static boolean compareDate(String date1, String date2,String date3){
		boolean result = false;
		if (date1 == null) {
			return false;
		}
		if (date2 == null) {
			return false;
		}
		if (date3 == null) {
			return false;
		}
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		try {
			//第三个时间如果满足 date1<date3<date2返回为真
			if (sdf.parse(date1).getTime() <= sdf.parse(date3).getTime() && sdf.parse(date2).getTime() >= sdf.parse(date3).getTime()) {
				result = true;
			}
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
	/**
	 * 时间加法
	 * 
	 * @param number
	 *            天数 或月数 的数值
	 * @param unit
	 *            天 或 月 的单位 unit 1为天 2为月
	 * @return
	 */
	public static Date addDate(int number, short unit) {
		
		Calendar c = Calendar.getInstance();
		if (1 == unit) {
			c.add(Calendar.DAY_OF_MONTH, number);
		}
		else {
			c.add(Calendar.MONTH, number);
		}
		return c.getTime();
	}
	/**
	 * 时间加法指定日期
	 * 
	 * @param number
	 *            天数 或月数 的数值
	 * @param unit
	 *            天 或 月 的单位 unit 1为天 2为月
	 * @return
	 */
	public static Date addDate(Date date,int number, short unit) {
		
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		if (1 == unit) {
			c.add(Calendar.DAY_OF_MONTH, number);
		}
		else {
			c.add(Calendar.MONTH, number);
		}
		return c.getTime();
	}
	/**
	 * 时间减法
	 * 
	 * @param number
	 *            天数 或月数 的数值
	 * @param unit
	 *            天 或 月 的单位 unit 1为天 2为月
	 * @return
	 */
	public static Date reduceDate(int number, short unit) {
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Calendar c = Calendar.getInstance();
		if (1 == unit) {
			c.add(Calendar.DAY_OF_MONTH, -number);
		}
		else {
			c.add(Calendar.MONTH, -number);
		}
		return c.getTime();
	}
	/**
	 * 设置给定时间的加减法
	 * @param date 时间字符串
	 * @param number 天数 减法 负数，加法 正数
	 * @param unit 天 或 月 的单位 unit 1为天 2为月
	 * @return
	 */
	public static String dateSet(String date,int number,int unit,String format){
		Calendar c = Calendar.getInstance();
		c.setTime(parse(date));
		if (1 == unit) {
			c.add(Calendar.DAY_OF_MONTH, number);
		}
		else {
			c.add(Calendar.MONTH, number);
		}
		return format(c.getTime(),format);
	}
	/**
	 * 设置给定时间的加减法
	 * @param date 时间字符串
	 * @param number 天数 减法 负数，加法 正数
	 * @param unit 天 或 月 的单位 unit 1为天 2为月
	 * @return
	 */
	public static Date dateSet(Date date,int number,int unit){
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		if (1 == unit) {
			c.add(Calendar.DAY_OF_MONTH, number);
		}
		else {
			c.add(Calendar.MONTH, number);
		}
		return c.getTime();
	}

	/**
	 * 计算两个日期之间相差的天数
	 * @param smdate 较小的时间
	 * @param bdate  较大的时间
	 * @return 相差天数
	 * @throws ParseException
	 */
	public static int daysBetween(String beginDate,String endDate)
	{
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		try {
			Date smdate=sdf.parse(beginDate);
			Date bdate=sdf.parse(endDate);
			smdate=sdf.parse(sdf.format(smdate));
			bdate=sdf.parse(sdf.format(bdate));
			Calendar cal = Calendar.getInstance();
			cal.setTime(smdate);
			long time1 = cal.getTimeInMillis();
			cal.setTime(bdate);
			long time2 = cal.getTimeInMillis();
			long between_days=(time2-time1)/(1000*3600*24);
			return Integer.parseInt(String.valueOf(between_days));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}

	/**
	 * 两个日期比较大小
	 * @param DATE1
	 * @param DATE2
	 * @return  DATE1 > DATE2   返回1
	 * 			DATE1 < DATE2   返回-1
	 * 		    DATE1 = DATE2   返回0
	 */
	public static int compare_date(String DATE1, String DATE2) {
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		try {
			Date dt1 = df.parse(DATE1);
			Date dt2 = df.parse(DATE2);
			if (dt1.getTime() > dt2.getTime()) {
				return 1;
			}else if (dt1.getTime() < dt2.getTime()) {
				return -1;
			}else {
				return 0;
			}
		} catch (Exception exception) {
			exception.printStackTrace();
		}
		return 0;
	}

	public static void main(String[] args) {
		StringBuffer buf = new StringBuffer("@bjb|北京北|VAP|beijingbei|bjb|0@bjd|北京东|BOP|beijingdong|bjd|1@bji|北京|BJP|beijing|bj|2@bjn|北京南|VNP|beijingnan|bjn|3@bjx|北京西|BXP|beijingxi|bjx|4@gzn|广州南|IZQ|guangzhounan|gzn|5@cqb|重庆北|CUW|chongqingbei|cqb|6@cqi|重庆|CQW|chongqing|cq|7@cqn|重庆南|CRW|chongqingnan|cqn|8@cqx|重庆西|CXW|chongqingxi|cqx|9@gzd|广州东|GGQ|guangzhoudong|gzd|10@sha|上海|SHH|shanghai|sh|11@shn|上海南|SNH|shanghainan|shn|12@shq|上海虹桥|AOH|shanghaihongqiao|shhq|13@shx|上海西|SXH|shanghaixi|shx|14@tjb|天津北|TBP|tianjinbei|tjb|15@tji|天津|TJP|tianjin|tj|16@tjn|天津南|TIP|tianjinnan|tjn|17@tjx|天津西|TXP|tianjinxi|tjx|18");
		buf.append("@xgl|香港西九龙|XJA|hkwestkowloon|xgxjl|19@cch|长春|CCT|changchun|cc|20@ccn|长春南|CET|changchunnan|ccn|21@ccx|长春西|CRT|changchunxi|ccx|22@cdd|成都东|ICW|chengdudong|cdd|23@cdn|成都南|CNW|chengdunan|cdn|24@cdu|成都|CDW|chengdu|cd|25@cdx|成都西|CMW|chengduxi|cdx|26@csh|长沙|CSQ|changsha|cs|27@csn|长沙南|CWQ|changshanan|csn|28@dmh|大明湖|JAK|daminghu|dmh|29@fzh|福州|FZS|fuzhou|fz|30@fzn|福州南|FYS|fuzhounan|fzn|31@gya|贵阳|GIW|guiyang|gy|32@gzh|广州|GZQ|guangzhou|gz|33@gzx|广州西|GXQ|guangzhouxi|gzx|34@heb|哈尔滨|HBB|haerbin|heb|35@hed|哈尔滨东|VBB|haerbindong|hebd|36@hex|哈尔滨西|VAB|haerbinxi|hebx|37@hfe|合肥|HFH|hefei|hf|38@hfx|合肥西|HTH|hefeixi|hfx|39@hhd|呼和浩特东|NDC|huhehaotedong|hhhtd|40@hht|呼和浩特|HHC|huhehaote|hhht|41@hkd|海口东|HMQ|haikoudong|hkd|43@hko|海口|VUQ|haikou|hk|44@hzd|杭州东|HGH|hangzhoudong|hzd|45@hzh|杭州|HZH|hangzhou|hz|46@hzn|杭州南|XHH|hangzhounan|hzn|47@jna|济  南|EEI|jinan|jn|48@jna|济南|JNK|jinan|jn|49@jnx|济  南西|EII|jinanxi|jnx|50@jnx|济南西|JGK|jinanxi|jnx|51@kmi|昆明|KMM|kunming|km|52@kmx|昆明西|KXM|kunmingxi|kmx|53@lsa|拉萨|LSO|lasa|ls|54@lzd|兰州东|LVJ|lanzhoudong|lzd|55@lzh|兰州|LZJ|lanzhou|lz|56@lzx|兰州西|LAJ|lanzhouxi|lzx|57@nch|南昌|NCG|nanchang|nc|58@nji|南京|NJH|nanjing|nj|59@njn|南京南|NKH|nanjingnan|njn|60@nni|南宁|NNZ|nanning|nn|61@sjb|石家庄北|VVP|shijiazhuangbei|sjzb|62@sjz|石家庄|SJP|shijiazhuang|sjz|63@sya|沈阳|SYT|shenyang|sy|64@syb|沈阳北|SBT|shenyangbei|syb|65@syd|沈阳东|SDT|shenyangdong|syd|66@syn|沈阳南|SOT|shenyangnan|syn|67@tyb|太原北|TBV|taiyuanbei|tyb|68@tyd|太原东|TDV|taiyuandong|tyd|69@tyu|太原|TYV|taiyuan|ty|70@wha|武汉|WHN|wuhan|wh|71@wjx|王家营西|KNM|wangjiayingxi|wjyx|72@wlq|乌鲁木齐|WAR|wulumuqi|wlmq|73@xab|西安北|EAY|xianbei|xab|74@xan|西安|XAY|xian|xa|75@xan|西安南|CAY|xiannan|xan|76@xni|西宁|XNO|xining|xn|77@ych|银川|YIJ|yinchuan|yc|78@zzh|郑州|ZZF|zhengzhou|zz|79@aes|阿尔山|ART|aershan|aes|80@aka|安康|AKY|ankang|ak|81@aks|阿克苏|ASR|akesu|aks|82@alh|阿里河|AHX|alihe|alh|83@alk|阿拉山口|AKR|alashankou|alsk|84@api|安平|APT|anping|ap|85@aqi|安庆|AQH|anqing|aq|86@ash|安顺|ASW|anshun|as|87@ash|鞍山|AST|anshan|as|88@aya|安阳|AYF|anyang|ay|89@ban|北安|BAB|beian|ba|90@bbu|蚌埠|BBH|bengbu|bb|91@bch|白城|BCT|baicheng|bc|92@bha|北海|BHZ|beihai|bh|93@bhe|白河|BEL|baihe|bh|94@bji|白涧|BAP|baijian|bj|95@bji|宝鸡|BJY|baoji|bj|96@bji|滨江|BJB|binjiang|bj|97@bkt|博克图|BKX|boketu|bkt|98@bse|百色|BIZ|baise|bs|99@bss|白山市|HJL|baishanshi|bss|100@bta|北台|BTT|beitai|bt|101@btd|包头东|BDC|baotoudong|btd|102@bto|包头|BTC|baotou|bt|103@bts|北屯市|BXR|beitunshi|bts|104@bxi|本溪|BXT|benxi|bx|105@byb|白云鄂博|BEC|baiyunebo|byeb|106@byx|白银西|BXJ|baiyinxi|byx|107@bzh|亳州|BZH|bozhou|bz|108@cbi|赤壁|CBN|chibi|cb|109@cde|常德|VGQ|changde|cd|110@cde|承德|CDP|chengde|cd|111@cdi|长甸|CDT|changdian|cd|112@cfn|赤峰南|CFD|chifengnan|cfn|113@cli|茶陵|CDG|chaling|cl|114@cna|苍南|CEH|cangnan|cn|115@cpi|昌平|CPP|changping|cp|116@cre|崇仁|CRG|chongren|cr|117@ctu|昌图|CTT|changtu|ct|118@ctz|长汀镇|CDB|changtingzhen|ctz|119@cxi|曹县|CXK|caoxian|cx|120@cxn|楚雄南|COM|chuxiongnan|cxn|121@cxt|陈相屯|CXT|chenxiangtun|cxt|122@czb|长治北|CBF|changzhibei|czb|123@czh|池州|IYH|chizhou|cz|124@czh|长征|CZJ|changzheng|cz|125@czh|常州|CZH|changzhou|cz|126@czh|郴州|CZQ|chenzhou|cz|127@czh|长治|CZF|changzhi|cz|128@czh|沧州|COP|cangzhou|cz|129@czu|崇左|CZZ|chongzuo|cz|130@dab|大安北|RNT|daanbei|dab|131@dch|大成|DCT|dacheng|dc|132@ddo|丹东|DUT|dandong|dd|133@dfh|东方红|DFB|dongfanghong|dfh|134@dgd|东莞东|DMQ|dongguandong|dgd|135@dhs|大虎山|DHD|dahushan|dhs|136@dhu|敦煌|DHJ|dunhuang|dh|137@dhu|敦化|DHL|dunhua|dh|138@dhu|德惠|DHT|dehui|dh|139@djc|东京城|DJB|dongjingcheng|djc|140@dji|大涧|DFP|dajian|dj|141@djy|都江堰|DDW|dujiangyan|djy|142@dlb|大连北|DFT|dalianbei|dlb|143@dli|大理|DKM|dali|dl|144@dli|大连|DLT|dalian|dl|145@dna|定南|DNG|dingnan|dn|146@dqi|大庆|DZX|daqing|dq|147@dsh|东胜|DOC|dongsheng|ds|148@dsq|大石桥|DQT|dashiqiao|dsq|149@dto|大同|DTV|datong|dt|150@dyi|东营|DPK|dongying|dy|151@dys|大杨树|DUX|dayangshu|dys|152@dyu|都匀|RYW|duyun|dy|153@dzh|邓州|DOF|dengzhou|dz|154@dzh|达州|RXW|dazhou|dz|155@dzh|德州|DZP|dezhou|dz|156@ejn|额济纳|EJC|ejina|ejn|157@eli|二连|RLC|erlian|el|158@esh|恩施|ESN|enshi|es|159@fdi|福鼎|FES|fuding|fd|160@fhc|凤凰机场|FJQ|fenghuangjichang|fhjc|161@fld|风陵渡|FLV|fenglingdu|fld|162@fli|涪陵|FLW|fuling|fl|163@flj|富拉尔基|FRX|fulaerji|flej|164@fsb|抚顺北|FET|fushunbei|fsb|165@fsh|佛山|FSQ|foshan|fs|166@fxn|阜新南|FXD|fuxinnan|fxn|167@fya|阜阳|FYH|fuyang|fy|168@gem|格尔木|GRO|geermu|gem|169@gha|广汉|GHW|guanghan|gh|170@gji|古交|GJV|gujiao|gj|171@glb|桂林北|GBZ|guilinbei|glb|172@gli|古莲|GRX|gulian|gl|173@gli|桂林|GLZ|guilin|gl|174@gsh|固始|GXN|gushi|gs|175@gsh|广水|GSN|guangshui|gs|176@gta|干塘|GNJ|gantang|gt|177@gyu|广元|GYW|guangyuan|gy|178@gzb|广州北|GBQ|guangzhoubei|gzb|179@gzh|赣州|GZG|ganzhou|gz|180@gzl|公主岭|GLT|gongzhuling|gzl|181@gzn|公主岭南|GBT|gongzhulingnan|gzln|182@han|淮安|AUH|huaian|ha|183@hbe|淮北|HRH|huaibei|hb|184@hbe|鹤北|HMB|hebei|hb|185@hbi|淮滨|HVN|huaibin|hb|186@hbi|河边|HBV|hebian|hb|187@hch|潢川|KCN|huangchuan|hc|188@hch|韩城|HCY|hancheng|hc|189@hda|邯郸|HDP|handan|hd|190@hdz|横道河子|HDB|hengdaohezi|hdhz|191@hga|鹤岗|HGB|hegang|hg|192@hgt|皇姑屯|HTT|huanggutun|hgt|193@hgu|红果|HEM|hongguo|hg|194@hhe|黑河|HJB|heihe|hh|195@hhu|怀化|HHQ|huaihua|hh|196@hko|汉口|HKN|hankou|hk|197@hld|葫芦岛|HLD|huludao|hld|198@hle|海拉尔|HRX|hailaer|hle|199@hll|霍林郭勒|HWD|huolinguole|hlgl|200@hlu|海伦|HLB|hailun|hl|201@hma|侯马|HMV|houma|hm|202@hmi|哈密|HMR|hami|hm|203@hna|淮南|HAH|huainan|hn|204@hna|桦南|HNB|huanan|hn|205@hnx|海宁西|EUH|hainingxi|hnx|206@hqi|鹤庆|HQM|heqing|hq|207@hrb|怀柔北|HBP|huairoubei|hrb|208@hro|怀柔|HRP|huairou|hr|209@hsd|黄石东|OSN|huangshidong|hsd|210@hsh|华山|HSY|huashan|hs|211@hsh|黄山|HKH|huangshan|hs|212@hsh|黄石|HSN|huangshi|hs|213@hsh|衡水|HSP|hengshui|hs|214@hya|衡阳|HYQ|hengyang|hy|215@hze|菏泽|HIK|heze|hz|216@hzh|贺州|HXZ|hezhou|hz|217@hzh|汉中|HOY|hanzhong|hz|218@hzh|惠州|HCQ|huizhou|hz|219@jan|吉安|VAG|jian|ja|220@jan|集安|JAL|jian|ja|221@jbc|江边村|JBG|jiangbiancun|jbc|222@jch|晋城|JCF|jincheng|jc|223@jcj|金城江|JJZ|jinchengjiang|jcj|224@jdz|景德镇|JCG|jingdezhen|jdz|225@jfe|嘉峰|JFF|jiafeng|jf|226@jgq|加格达奇|JGX|jiagedaqi|jgdq|227@jgs|井冈山|JGG|jinggangshan|jgs|228@jhe|蛟河|JHL|jiaohe|jh|229@jhn|金华南|RNH|jinhuanan|jhn|230@jhu|金华|JBH|jinhua|jh|231@jji|九江|JJG|jiujiang|jj|232@jli|吉林|JLL|jilin|jl|233@jme|荆门|JMN|jingmen|jm|234@jms|佳木斯|JMB|jiamusi|jms|235@jni|济宁|JIK|jining|jn|236@jnn|集宁南|JAC|jiningnan|jnn|237@jqu|酒泉|JQJ|jiuquan|jq|238@jsh|江山|JUH|jiangshan|js|239@jsh|吉首|JIQ|jishou|js|240@jta|九台|JTL|jiutai|jt|241@jts|镜铁山|JVJ|jingtieshan|jts|242@jxi|鸡西|JXB|jixi|jx|243@jxx|绩溪县|JRH|jixixian|jxx|244@jyg|嘉峪关|JGJ|jiayuguan|jyg|245@jyo|江油|JFW|jiangyou|jy|246@jzb|蓟州北|JKP|jizhoubei|jzb|247@jzh|锦州|JZD|jinzhou|jz|248@jzh|金州|JZT|jinzhou|jz|249@kel|库尔勒|KLR|kuerle|kel|250@kfe|开封|KFF|kaifeng|kf|251@kla|岢岚|KLV|kelan|kl|252@kli|凯里|KLW|kaili|kl|253@ksh|喀什|KSR|kashi|ks|254@ksn|昆山南|KNH|kunshannan|ksn|255@ktu|奎屯|KTR|kuitun|kt|256@kyu|开原|KYT|kaiyuan|ky|257@lan|六安|UAH|luan|la|258@lba|灵宝|LBF|lingbao|lb|259@lcg|芦潮港|UCH|luchaogang|lcg|260@lch|陆川|LKZ|luchuan|lc|261@lch|利川|LCN|lichuan|lc|262@lch|潞城|UTP|lucheng|lc|263@lch|隆昌|LCW|longchang|lc|264@lch|临川|LCG|linchuan|lc|265@lda|鹿道|LDL|ludao|ld|266@ldi|娄底|LDQ|loudi|ld|267@lfe|临汾|LFV|linfen|lf|268@lgz|良各庄|LGP|lianggezhuang|lgz|269@lhe|临河|LHC|linhe|lh|270@lhe|漯河|LON|luohe|lh|271@lhu|绿化|LWJ|lvhua|lh|272@lhu|隆化|UHP|longhua|lh|273@lji|丽江|LHM|lijiang|lj|274@lji|龙井|LJL|longjing|lj|275@lji|临江|LQL|linjiang|lj|276@lli|吕梁|LHV|lvliang|ll|277@lli|醴陵|LLG|liling|ll|278@lln|柳林南|LKV|liulinnan|lln|279@lpi|滦平|UPP|luanping|lp|280@lps|六盘水|UMW|liupanshui|lps|281@lqi|灵丘|LVV|lingqiu|lq|282@lsh|旅顺|LST|lvshun|ls|283@lxi|兰溪|LWH|lanxi|lx|284@lxi|陇西|LXJ|longxi|lx|285@lxi|澧县|LEQ|lixian|lx|286@lxi|临西|UEP|linxi|lx|287@lya|龙岩|LYS|longyan|ly|288@lya|耒阳|LYQ|leiyang|ly|289@lya|洛阳|LYF|luoyang|ly|290@lyd|连云港东|UKH|lianyungangdong|lygd|291@lyd|洛阳东|LDF|luoyangdong|lyd|292@lyi|临沂|LVK|linyi|ly|293@lym|洛阳龙门|LLF|luoyanglongmen|lylm|294@lyu|柳园|DHR|liuyuan|ly|295@lyu|凌源|LYD|lingyuan|ly|296@lyu|辽源|LYL|liaoyuan|ly|297@lzh|立志|LZX|lizhi|lz|298@lzh|柳州|LZZ|liuzhou|lz|299@lzh|辽中|LZD|liaozhong|lz|300@mch|麻城|MCN|macheng|mc|301@mdh|免渡河|MDX|mianduhe|mdh|302@mdj|牡丹江|MDB|mudanjiang|mdj|303@meg|莫尔道嘎|MRX|moerdaoga|medg|304@mgu|满归|MHX|mangui|mg|305@mgu|明光|MGH|mingguang|mg|306@mhe|漠河|MVX|mohe|mh|307@mmi|茂名|MDQ|maoming|mm|308@mmx|茂名西|MMZ|maomingxi|mmx|309@msh|密山|MSB|mishan|ms|310@msj|马三家|MJT|masanjia|msj|311@mwe|麻尾|VAW|mawei|mw|312@mya|绵阳|MYW|mianyang|my|313@mzh|梅州|MOQ|meizhou|mz|314@mzl|满洲里|MLX|manzhouli|mzl|315@nbd|宁波东|NVH|ningbodong|nbd|316@nbo|宁波|NGH|ningbo|nb|317@nch|南岔|NCB|nancha|nc|318@nch|南充|NCW|nanchong|nc|319@nda|南丹|NDZ|nandan|nd|320@ndm|南大庙|NMP|nandamiao|ndm|321@nfe|南芬|NFT|nanfen|nf|322@nhe|讷河|NHX|nehe|nh|323@nji|嫩江|NGX|nenjiang|nj|324@nji|内江|NJW|neijiang|nj|325@nto|南通|NUH|nantong|nt|326@nya|南阳|NFF|nanyang|ny|327@nzs|碾子山|NZX|nianzishan|nzs|328@pds|平顶山|PEN|pingdingshan|pds|329@pji|盘锦|PVD|panjin|pj|330@pli|平凉|PIJ|pingliang|pl|331@pln|平凉南|POJ|pingliangnan|pln|332@pqu|平泉|PQP|pingquan|pq|333@psh|坪石|PSQ|pingshi|ps|334@pxi|萍乡|PXG|pingxiang|px|335@pxi|凭祥|PXZ|pingxiang|px|336@pxx|郫县西|PCW|pixianxi|pxx|337@pzh|攀枝花|PRW|panzhihua|pzh|338@qch|蕲春|QRN|qichun|qc|339@qcs|青城山|QSW|qingchengshan|qcs|340@qda|青岛|QDK|qingdao|qd|341@qhc|清河城|QYP|qinghecheng|qhc|342@qji|曲靖|QJM|qujing|qj|343@qji|黔江|QNW|qianjiang|qj|344@qjz|前进镇|QEB|qianjinzhen|qjz|345@qqe|齐齐哈尔|QHX|qiqihaer|qqhe|346@qth|七台河|QTB|qitaihe|qth|347@qxi|沁县|QVV|qinxian|qx|348@qzd|泉州东|QRS|quanzhoudong|qzd|349@qzh|泉州|QYS|quanzhou|qz|350@qzh|衢州|QEH|quzhou|qz|351@ran|融安|RAZ|rongan|ra|352@rjg|汝箕沟|RQJ|rujigou|rjg|353@rji|瑞金|RJG|ruijin|rj|354@rzh|日照|RZK|rizhao|rz|355@scp|双城堡|SCB|shuangchengpu|scp|356@sfh|绥芬河|SFB|suifenhe|sfh|357@sgd|韶关东|SGQ|shaoguandong|sgd|358@shg|山海关|SHD|shanhaiguan|shg|359@shu|绥化|SHB|suihua|sh|360@sjf|三间房|SFX|sanjianfang|sjf|361@sjt|苏家屯|SXT|sujiatun|sjt|362@sla|舒兰|SLL|shulan|sl|363@smn|神木南|OMY|shenmunan|smn|364@smx|三门峡|SMF|sanmenxia|smx|365@sna|商南|ONY|shangnan|sn|366@sni|遂宁|NIW|suining|sn|367@spi|四平|SPT|siping|sp|368@sqi|商丘|SQF|shangqiu|sq|369@sra|上饶|SRG|shangrao|sr|370@ssh|韶山|SSQ|shaoshan|ss|371@sso|宿松|OAH|susong|ss|372@sto|汕头|OTQ|shantou|st|373@swu|邵武|SWS|shaowu|sw|374@sxi|涉县|OEP|shexian|sx|375@sya|三亚|SEQ|sanya|sy|376@sya|邵阳|SYQ|shaoyang|sy|378@sya|十堰|SNN|shiyan|sy|379@syq|三元区|SMS|sanyuanqu|syq|380@sys|双鸭山|SSB|shuangyashan|sys|381@syu|松原|VYT|songyuan|sy|382@szh|宿州|OXH|suzhou|sz|383@szh|苏州|SZH|suzhou|sz|384@szh|深圳|SZQ|shenzhen|sz|385@szh|随州|SZN|suizhou|sz|386@szh|朔州|SUV|shuozhou|sz|387@szx|深圳西|OSQ|shenzhenxi|szx|388@tba|塘豹|TBQ|tangbao|tb|389@teq|塔尔气|TVX|taerqi|teq|390@tgu|潼关|TGY|tongguan|tg|391@tgu|塘沽|TGP|tanggu|tg|392@the|塔河|TXX|tahe|th|393@thu|通化|THL|tonghua|th|394@tla|泰来|TLX|tailai|tl|395@tlf|吐鲁番|TFR|tulufan|tlf|396@tli|通辽|TLD|tongliao|tl|397@tli|铁岭|TLT|tieling|tl|398@tlz|陶赖昭|TPT|taolaizhao|tlz|399@tme|图们|TML|tumen|tm|400@tre|铜仁|RDQ|tongren|tr|401@tsb|唐山北|FUP|tangshanbei|tsb|402@tsf|田师府|TFT|tianshifu|tsf|403@tsh|泰山|TAK|taishan|ts|404@tsh|天水|TSJ|tianshui|ts|405@tsh|唐山|TSP|tangshan|ts|406@typ|通远堡|TYT|tongyuanpu|typ|407@tys|太阳升|TQT|taiyangsheng|tys|408@tzh|泰州|UTH|taizhou|tz|409@tzi|桐梓|TZW|tongzi|tz|410@tzx|通州西|TAP|tongzhouxi|tzx|411@wch|五常|WCB|wuchang|wc|412@wch|武昌|WCN|wuchang|wc|413@wfd|瓦房店|WDT|wafangdian|wfd|414@wha|威海|WKK|weihai|wh|415@whu|芜湖|WHH|wuhu|wh|416@whx|乌海西|WXC|wuhaixi|whx|417@wjt|吴家屯|WJT|wujiatun|wjt|418@wln|乌鲁木齐南|WMR|wulumuqinan|wlmqn|419@wlo|武隆|WLW|wulong|wl|420@wlt|乌兰浩特|WWT|wulanhaote|wlht|421@wna|渭南|WNY|weinan|wn|422@wsh|威舍|WSM|weishe|ws|423@wts|歪头山|WIT|waitoushan|wts|424@wwe|武威|WUJ|wuwei|ww|425@wwn|武威南|WWJ|wuweinan|wwn|426@wxi|无锡|WXH|wuxi|wx|427@wxi|乌西|WXR|wuxi|wx|428@wyl|乌伊岭|WPB|wuyiling|wyl|429@wys|武夷山|WAS|wuyishan|wys|430@wyu|万源|WYY|wanyuan|wy|431@wzh|万州|WYW|wanzhou|wz|432@wzh|梧州|WZZ|wuzhou|wz|433@wzh|温州|RZH|wenzhou|wz|434@wzn|温州南|VRH|wenzhounan|wzn|435@xch|西昌|ECW|xichang|xc|436@xch|许昌|XCF|xuchang|xc|437@xcn|西昌南|ENW|xichangnan|xcn|438@xlt|锡林浩特|XTC|xilinhaote|xlht|439@xmb|厦门北|XKS|xiamenbei|xmb|440@xme|厦门|XMS|xiamen|xm|441@xmq|厦门高崎|XBS|xiamengaoqi|xmgq|442@xwe|宣威|XWM|xuanwei|xw|443@xxi|新乡|XXF|xinxiang|xx|444@xya|信阳|XUN|xinyang|xy|445@xya|咸阳|XYY|xianyang|xy|446@xya|襄阳|XFN|xiangyang|xy|447@xyc|熊岳城|XYT|xiongyuecheng|xyc|448@xyu|新余|XUG|xinyu|xy|449@xzh|徐州|XCH|xuzhou|xz|450@yan|延安|YWY|yanan|ya|451@ybi|宜宾|YBW|yibin|yb|452@ybn|亚布力南|YWB|yabulinan|ybln|453@ybs|叶柏寿|YBD|yebaishou|ybs|454@ycd|宜昌东|HAN|yichangdong|ycd|455@ych|永川|YCW|yongchuan|yc|456@ych|盐城|AFH|yancheng|yc|457@ych|运城|YNV|yuncheng|yc|458@ych|伊春|YCB|yichun|yc|459@ych|宜昌|YCN|yichang|yc|460@yci|榆次|YCV|yuci|yc|461@ycu|杨村|YBP|yangcun|yc|462@ycx|宜春西|YCG|yichunxi|ycx|463@yes|伊尔施|YET|yiershi|yes|464@yga|燕岗|YGW|yangang|yg|465@yji|永济|YIV|yongji|yj|466@yji|延吉|YJL|yanji|yj|467@yko|营口|YKT|yingkou|yk|468@yks|牙克石|YKX|yakeshi|yks|469@yli|阎良|YNY|yanliang|yl|470@yli|玉林|YLZ|yulin|yl|471@yli|榆林|ALY|yulin|yl|472@ylw|亚龙湾|TWQ|yalongwan|ylw|473@ymp|一面坡|YPB|yimianpo|ymp|474@yni|伊宁|YMR|yining|yn|475@ypg|阳平关|YAY|yangpingguan|ypg|476@ypi|玉屏|YZW|yuping|yp|477@ypi|原平|YPV|yuanping|yp|478@yqi|延庆|YNP|yanqing|yq|479@yqq|阳泉曲|YYV|yangquanqu|yqq|480@yqu|玉泉|YQB|yuquan|yq|481@yqu|阳泉|AQP|yangquan|yq|482@ysh|营山|NUW|yingshan|ys|483@ysh|玉山|YNG|yushan|ys|484@ysh|燕山|AOP|yanshan|ys|485@ysh|榆树|YRT|yushu|ys|486@yta|鹰潭|YTG|yingtan|yt|487@yta|烟台|YAK|yantai|yt|488@yth|伊图里河|YEX|yitulihe|ytlh|489@ytx|玉田县|ATP|yutianxian|ytx|490@ywu|义乌|YWH|yiwu|yw|491@yxi|阳新|YON|yangxin|yx|492@yxi|义县|YXD|yixian|yx|493@yya|益阳|AEQ|yiyang|yy|494@yya|岳阳|YYQ|yueyang|yy|495@yzh|崖州|YUQ|yazhou|yz|496@yzh|扬州|YLH|yangzhou|yz|497@yzh|永州|AOQ|yongzhou|yz|498@zbo|淄博|ZBK|zibo|zb|499@zcd|镇城底|ZDV|zhenchengdi|zcd|500@zgo|自贡|ZGW|zigong|zg|501@zha|珠海|ZHQ|zhuhai|zh|502@zhb|珠海北|ZIQ|zhuhaibei|zhb|503@zji|湛江|ZJZ|zhanjiang|zj|504@zji|镇江|ZJH|zhenjiang|zj|505@zjj|张家界|DIQ|zhangjiajie|zjj|506@zjk|张家口|ZMP|zhangjiakou|zjk|507@zko|周口|ZKN|zhoukou|zk|508@zlt|扎兰屯|ZTX|zhalantun|zlt|509@zmd|驻马店|ZDN|zhumadian|zmd|510@zqi|肇庆|ZVQ|zhaoqing|zq|511@zsz|周水子|ZIT|zhoushuizi|zsz|512@zto|昭通|ZDW|zhaotong|zt|513@zwe|中卫|ZWJ|zhongwei|zw|514@zya|资阳|ZYW|ziyang|zy|515@zyx|遵义西|ZIW|zunyixi|zyx|516@zzh|枣庄|ZEK|zaozhuang|zz|517@zzh|资中|ZZW|zizhong|zz|518@zzh|株洲|ZZQ|zhuzhou|zz|519@zzx|枣庄西|ZFK|zaozhuangxi|zzx|520@aax|昂昂溪|AAX|angangxi|aax|521@ach|阿城|ACB|acheng|ac|522@ada|安达|ADX|anda|ad|523@ade|安德|ARW|ande|ad|524@adi|安定|ADP|anding|ad|525@adu|安多|ADO|anduo|ad|526@agu|安广|AGT|anguang|ag|527@aha|敖汉|YED|aohan|ah|528@ahe|艾河|AHP|aihe|ah|529@ahu|安化|PKQ|anhua|ah|530@ajc|艾家村|AJJ|aijiacun|ajc|531@aji|安家|AJB|anjia|aj|532@aji|阿金|AJD|ajin|aj|533@aji|安靖|PYW|anjing|aj|534@akt|阿克陶|AER|aketao|akt|535@aky|安口窑|AYY|ankouyao|aky|536@alg|敖力布告|ALD|aolibugao|albg|537@alo|安龙|AUZ|anlong|al|538@als|阿龙山|ASX|alongshan|als|539@alu|安陆|ALN|anlu|al|540@ame|阿木尔|JTX|amuer|ame|541@anz|阿南庄|AZM|ananzhuang|anz|542@aqx|安庆西|APH|anqingxi|aqx|543@asx|鞍山西|AXT|anshanxi|asx|544@ata|安塘|ATV|antang|at|545@atb|安亭北|ASH|antingbei|atb|546@ats|阿图什|ATR|atushi|ats|547@atu|安图|ATL|antu|at|548@axi|安溪|AXS|anxi|ax|549@bao|博鳌|BWQ|boao|ba|550@bbe|北碚|BPW|beibei|bb|551@bbg|白壁关|BGV|baibiguan|bbg|552@bbn|蚌埠南|BMH|bengbunan|bbn|553@bch|巴楚|BCR|bachu|bc|554@bch|板城|BUP|bancheng|bc|555@bdh|北戴河|BEP|beidaihe|bdh|556@bdi|保定|BDP|baoding|bd|557@bdi|宝坻|BPP|baodi|bd|558@bdl|八达岭|ILP|badaling|bdl|559@bdo|巴东|BNN|badong|bd|560@bfe|宝丰|BFF|baofeng|bf|561@bgu|柏果|BGM|baiguo|bg|562@bha|布海|BUT|buhai|bh|563@bhd|白河东|BIY|baihedong|bhd|564@bhs|宝华山|BWH|baohuashan|bhs|565@bhx|白河县|BEY|baihexian|bhx|566@bjg|白芨沟|BJJ|baijigou|bjg|567@bjg|碧鸡关|BJM|bijiguan|bjg|568@bji|北滘|IBQ|beijiao|bj|569@bji|碧江|BLQ|bijiang|bj|570@bjp|白鸡坡|BBM|baijipo|bjp|571@bjs|笔架山|BSB|bijiashan|bjs|572@bjt|八角台|BTD|bajiaotai|bjt|573@bka|保康|BKD|baokang|bk|574@bkp|白奎堡|BKB|baikuipu|bkp|575@bla|白狼|BAT|bailang|bl|576@bla|百浪|BRZ|bailang|bl|577@ble|博乐|BOR|bole|bl|578@bli|巴林|BLX|balin|bl|579@bli|宝林|BNB|baolin|bl|580@bli|北流|BOZ|beiliu|bl|581@bli|勃利|BLB|boli|bl|582@blk|布列开|BLR|buliekai|blk|583@bls|宝龙山|BND|baolongshan|bls|584@blx|百里峡|AAP|bailixia|blx|585@bmc|八面城|BMD|bamiancheng|bmc|586@bmq|班猫箐|BNM|banmaoqing|bmq|587@bmt|八面通|BMB|bamiantong|bmt|588@bmz|北马圈子|BRP|beimaquanzi|bmqz|589@bpn|北票南|RPD|beipiaonan|bpn|590@bqi|白旗|BQP|baiqi|bq|591@bql|宝泉岭|BQB|baoquanling|bql|592@bqu|白泉|BQL|baiquan|bq|593@bsh|巴山|BAY|bashan|bs|594@bsj|白水江|BSY|baishuijiang|bsj|595@bsp|白沙坡|BPM|baishapo|bsp|596@bss|白石山|BAL|baishishan|bss|597@bsz|白水镇|BUM|baishuizhen|bsz|598@btd|包头 东|FDC|baotoudong|btd|599@bti|坂田|BTQ|bantian|bt|600@bto|泊头|BZP|botou|bt|601@btu|北屯|BYP|beitun|bt|602@bxh|本溪湖|BHT|benxihu|bxh|603@bxi|博兴|BXK|boxing|bx|604@bxt|八仙筒|VXD|baxiantong|bxt|605@byg|白音察干|BYC|baiyinchagan|bycg|606@byh|背荫河|BYB|beiyinhe|byh|607@byi|北营|BIV|beiying|by|608@byl|巴彦高勒|BAC|bayangaole|bygl|609@byl|白音他拉|BID|baiyintala|bytl|610@byq|鲅鱼圈|BYT|bayuquan|byq|611@bys|白银市|BNJ|baiyinshi|bys|612@bys|白音胡硕|BCD|baiyinhushuo|byhs|613@bzh|巴中|IEW|bazhong|bz|614@bzh|霸州|RMP|bazhou|bz|615@bzh|北宅|BVP|beizhai|bz|616@cbb|赤壁北|CIN|chibibei|cbb|617@cbg|查布嘎|CBC|chabuga|cbg|618@cch|长城|CEJ|changcheng|cc|619@cch|长冲|CCM|changchong|cc|620@cdd|承德东|CCP|chengdedong|cdd|621@cfe|赤峰|CID|chifeng|cf|622@cga|嵯岗|CAX|cuogang|cg|623@cga|柴岗|CGT|chaigang|cg|624@cge|长葛|CEF|changge|cg|625@cgp|柴沟堡|CGV|chaigoupu|cgp|626@cgu|城固|CGY|chenggu|cg|627@cgy|陈官营|CAJ|chenguanying|cgy|628@cgz|成高子|CZB|chenggaozi|cgz|629@cha|草海|WBW|caohai|ch|630@che|柴河|CHB|chaihe|ch|631@che|册亨|CHZ|ceheng|ch|632@chk|草河口|CKT|caohekou|chk|633@chk|崔黄口|CHP|cuihuangkou|chk|634@chu|巢湖|CIH|chaohu|ch|635@cjg|蔡家沟|CJT|caijiagou|cjg|636@cjh|成吉思汗|CJX|chengjisihan|cjsh|637@cji|岔江|CAM|chajiang|cj|638@cjp|蔡家坡|CJY|caijiapo|cjp|639@cle|昌乐|CLK|changle|cl|640@clg|超梁沟|CYP|chaolianggou|clg|641@cli|慈利|CUQ|cili|cl|642@cli|昌黎|CLP|changli|cl|643@clz|长岭子|CLT|changlingzi|clz|644@cmi|晨明|CMB|chenming|cm|645@cno|长农|CNJ|changnong|cn|646@cpb|昌平北|VBP|changpingbei|cpb|647@cpi|常平|DAQ|changping|cp|648@cpl|长坡岭|CPM|changpoling|cpl|649@cqi|辰清|CQB|chenqing|cq|650@csh|楚山|CSB|chushan|cs|651@csh|蔡山|CON|caishan|cs|652@csh|磁山|CSP|cishan|cs|653@csh|苍石|CST|cangshi|cs|654@csh|草市|CSL|caoshi|cs|655@csh|长寿|EFW|changshou|cs|656@csq|察素齐|CSC|chasuqi|csq|657@cst|长山屯|CVT|changshantun|cst|658@cti|长汀|CES|changting|ct|659@ctn|朝天南|CTY|chaotiannan|ctn|660@ctx|昌图西|CPT|changtuxi|ctx|661@cwa|春湾|CQQ|chunwan|cw|662@cxi|磁县|CIP|cixian|cx|663@cxi|岑溪|CNZ|cenxi|cx|664@cxi|辰溪|CXQ|chenxi|cx|665@cxi|磁西|CRP|cixi|cx|666@cxn|长兴南|CFH|changxingnan|cxn|667@cya|磁窑|CYK|ciyao|cy|668@cya|春阳|CAL|chunyang|cy|669@cya|城阳|CEK|chengyang|cy|670@cyc|创业村|CEX|chuangyecun|cyc|671@cyc|朝阳川|CYL|chaoyangchuan|cyc|672@cyd|朝阳地|CDD|chaoyangdi|cyd|673@cyn|朝阳南|CYD|chaoyangnan|cyn|674@cyu|长垣|CYF|changyuan|cy|675@cyz|朝阳镇|CZL|chaoyangzhen|cyz|676@czb|滁州北|CUH|chuzhoubei|czb|677@czb|常州北|ESH|changzhoubei|czb|678@czh|滁州|CXH|chuzhou|cz|679@czh|潮州|CKQ|chaozhou|cz|680@czh|常庄|CVK|changzhuang|cz|681@czl|曹子里|CFP|caozili|czl|682@czw|车转湾|CWM|chezhuanwan|czw|683@czx|郴州西|ICQ|chenzhouxi|czx|684@czx|沧州西|CBP|cangzhouxi|czx|685@dan|德安|DAG|dean|da|686@dan|大安|RAT|daan|da|687@dba|大板|DBC|daban|db|688@dba|大坝|DBJ|daba|db|689@dba|大巴|DBD|daba|db|690@dba|电白|NWQ|dianbai|db|691@dba|到保|RBT|daobao|db|692@dbc|达坂城|DCR|dabancheng|dbc|693@dbi|定边|DYJ|dingbian|db|694@dbj|东边井|DBB|dongbianjing|dbj|695@dbs|德伯斯|RDT|debosi|dbs|696@dcg|打柴沟|DGJ|dachaigou|dcg|697@dch|德昌|DVW|dechang|dc|698@dda|滴道|DDB|didao|dd|699@ddg|大磴沟|DKJ|dadenggou|ddg|700@ded|刀尔登|DRD|daoerdeng|ded|701@dee|得耳布尔|DRX|deerbuer|debe|702@det|杜尔伯特|TKX|duerbote|debt|703@dfa|东方|UFQ|dongfang|df|704@dfe|丹凤|DGY|danfeng|df|705@dfe|东丰|DIL|dongfeng|df|706@dge|都格|DMM|duge|dg|707@dgt|大官屯|DTT|daguantun|dgt|708@dgu|东光|DGP|dongguang|dg|709@dgu|大关|RGW|daguan|dg|710@dha|东海|DHB|donghai|dh|711@dhc|大灰厂|DHP|dahuichang|dhc|712@dhq|大红旗|DQD|dahongqi|dhq|713@dht|大禾塘|SOQ|shaodong|dh|714@dhx|东海县|DQH|donghaixian|dhx|715@dhx|德惠西|DXT|dehuixi|dhx|716@djg|达家沟|DJT|dajiagou|djg|717@dji|东津|DKB|dongjin|dj|718@dji|杜家|DJL|dujia|dj|719@dkt|大口屯|DKP|dakoutun|dkt|720@dla|东来|RVD|donglai|dl|721@dlh|德令哈|DHO|delingha|dlh|722@dli|带岭|DLB|dailing|dl|723@dli|大林|DLD|dalin|dl|724@dlq|达拉特旗|DIC|dalateqi|dltq|725@dlt|独立屯|DTX|dulitun|dlt|726@dlu|豆罗|DLV|douluo|dl|727@dlx|达拉特西|DNC|dalatexi|dltx|728@dlx|大连西|GZT|dalianxi|dlx|729@dmc|东明村|DMD|dongmingcun|dmc|730@dmh|洞庙河|DEP|dongmiaohe|dmh|731@dmx|东明县|DNF|dongmingxian|dmx|732@dni|大拟|DNZ|dani|dn|733@dpf|大平房|DPD|dapingfang|dpf|734@dps|大盘石|RPP|dapanshi|dps|735@dpu|大埔|DPI|dapu|dp|736@dpu|大堡|DVT|dapu|dp|737@dqd|大庆东|LFX|daqingdong|dqd|738@dqh|大其拉哈|DQX|daqilaha|dqlh|739@dqi|道清|DML|daoqing|dq|740@dqs|对青山|DQB|duiqingshan|dqs|741@dqx|德清西|MOH|deqingxi|dqx|742@dqx|大庆西|RHX|daqingxi|dqx|743@dsh|砀山|DKH|dangshan|ds|744@dsh|独山|RWW|dushan|ds|745@dsh|东升|DRQ|dongsheng|ds|746@dsh|登沙河|DWT|dengshahe|dsh|747@dsp|读书铺|DPM|dushupu|dsp|748@dst|大石头|DSL|dashitou|dst|749@dsx|东胜西|DYC|dongshengxi|dsx|750@dsz|大石寨|RZT|dashizhai|dsz|751@dta|东台|DBH|dongtai|dt|752@dta|定陶|DQK|dingtao|dt|753@dta|灯塔|DGT|dengta|dt|754@dtb|大田边|DBM|datianbian|dtb|755@dth|东通化|DTL|dongtonghua|dth|756@dtu|丹徒|RUH|dantu|dt|757@dtu|大屯|DNT|datun|dt|758@dwa|东湾|DRJ|dongwan|dw|759@dwk|大武口|DFJ|dawukou|dwk|760@dwp|低窝铺|DWJ|diwopu|dwp|761@dwt|大王滩|DZZ|dawangtan|dwt|762@dwz|大湾子|DFM|dawanzi|dwz|763@dxg|大兴沟|DXL|daxinggou|dxg|764@dxi|大兴|DXX|daxing|dx|765@dxi|定西|DSJ|dingxi|dx|766@dxi|东乡|DXG|dongxiang|dx|767@dxi|代县|DKV|daixian|dx|768@dxi|甸心|DXM|dianxin|dx|769@dxi|定襄|DXV|dingxiang|dx|770@dxu|东戌|RXP|dongxu|dx|771@dxz|东辛庄|DXD|dongxinzhuang|dxz|772@dya|丹阳|DYH|danyang|dy|773@dya|大雁|DYX|dayan|dy|774@dya|德阳|DYW|deyang|dy|775@dya|当阳|DYN|dangyang|dy|776@dyb|丹阳北|EXH|danyangbei|dyb|777@dyd|大英东|IAW|dayingdong|dyd|778@dyd|东淤地|DBV|dongyudi|dyd|779@dyi|大营|DYV|daying|dy|780@dyu|定远|EWH|dingyuan|dy|781@dyu|岱岳|RYV|daiyue|dy|782@dyu|大元|DYZ|dayuan|dy|783@dyz|大营镇|DJP|dayingzhen|dyz|784@dyz|大营子|DZD|dayingzi|dyz|785@dzc|大战场|DTJ|dazhanchang|dzc|786@dzd|德州东|DIP|dezhoudong|dzd|787@dzh|东至|DCH|dongzhi|dz|788@dzh|低庄|DVQ|dizhuang|dz|789@dzh|东镇|DNV|dongzhen|dz|790@dzh|道州|DFZ|daozhou|dz|791@dzh|定州|DXP|dingzhou|dz|792@dzh|东庄|DZV|dongzhuang|dz|793@dzh|兑镇|DWV|duizhen|dz|794@dzh|豆庄|ROP|douzhuang|dz|795@dzy|大竹园|DZY|dazhuyuan|dzy|796@dzz|大杖子|DAP|dazhangzi|dzz|797@dzz|豆张庄|RZP|douzhangzhuang|dzz|798@ebi|峨边|EBW|ebian|eb|799@edm|二道沟门|RDP|erdaogoumen|edgm|800@edw|二道湾|RDX|erdaowan|edw|801@ees|鄂尔多斯|EEC|eerduosi|eeds|802@elo|二龙|RLD|erlong|el|803@elt|二龙山屯|ELA|erlongshantun|elst|804@eme|峨眉|EMW|emei|em|805@emh|二密河|RML|ermihe|emh|806@epi|恩平|PXQ|enping|ep|807@eyi|二营|RYJ|erying|ey|808@ezh|鄂州|ECN|ezhou|ez|809@fan|福安|FAS|fuan|fa|810@fch|丰城|FCG|fengcheng|fc|811@fcn|丰城南|FNG|fengchengnan|fcn|812@fdo|肥东|FIH|feidong|fd|813@fer|发耳|FEM|faer|fe|814@fha|富海|FHX|fuhai|fh|815@fha|福海|FHR|fuhai|fh|816@fhc|凤凰城|FHT|fenghuangcheng|fhc|817@fhe|汾河|FEV|fenhe|fh|818@fhu|奉化|FHH|fenghua|fh|819@fji|富锦|FIB|fujin|fj|820@fjt|范家屯|FTT|fanjiatun|fjt|821@flq|福利区|FLJ|fuliqu|flq|822@flt|福利屯|FTB|fulitun|flt|823@flz|丰乐镇|FZB|fenglezhen|flz|824@fna|阜南|FNH|funan|fn|825@fni|阜宁|AKH|funing|fn|826@fni|抚宁|FNP|funing|fn|827@fqi|福清|FQS|fuqing|fq|828@fqu|福泉|VMW|fuquan|fq|829@fsc|丰水村|FSJ|fengshuicun|fsc|830@fsh|丰顺|FUQ|fengshun|fs|831@fsh|繁峙|FSV|fanshi|fs|832@fsh|抚顺|FST|fushun|fs|833@fsk|福山口|FKP|fushankou|fsk|834@fsu|扶绥|FSZ|fusui|fs|835@ftu|冯屯|FTX|fengtun|ft|836@fty|浮图峪|FYP|futuyu|fty|837@fxd|富县东|FDY|fuxiandong|fxd|838@fxi|凤县|FXY|fengxian|fx|839@fxi|费县|FXK|feixian|fx|840@fxi|富县|FEY|fuxian|fx|841@fya|汾阳|FAV|fenyang|fy|842@fya|凤阳|FUH|fengyang|fy|843@fyb|扶余北|FBT|fuyubei|fyb|844@fyi|分宜|FYG|fenyi|fy|845@fyu|富源|FYM|fuyuan|fy|846@fyu|扶余|FYT|fuyu|fy|847@fyu|富裕|FYX|fuyu|fy|848@fzb|抚州北|FBG|fuzhoubei|fzb|849@fzh|凤州|FZY|fengzhou|fz|850@fzh|丰镇|FZC|fengzhen|fz|851@fzh|范镇|VZK|fanzhen|fz|852@gan|广安|VJW|guangan|ga|853@gan|固安|GFP|guan|ga|854@gbd|高碑店|GBP|gaobeidian|gbd|855@gbz|沟帮子|GBD|goubangzi|gbz|856@gcd|甘草店|GDJ|gancaodian|gcd|857@gch|谷城|GCN|gucheng|gc|858@gch|藁城|GEP|gaocheng|gc|859@gcu|高村|GCV|gaocun|gc|860@gcz|古城镇|GZB|guchengzhen|gcz|861@gde|广德|GRH|guangde|gd|862@gdi|贵定|GTW|guiding|gd|863@gdn|贵定南|IDW|guidingnan|gdn|864@gdo|古东|GDV|gudong|gd|865@gga|贵港|GGZ|guigang|gg|866@gga|官高|GVP|guangao|gg|867@ggm|葛根庙|GGT|gegenmiao|ggm|868@ggo|干沟|GGL|gangou|gg|869@ggu|甘谷|GGJ|gangu|gg|870@ggz|高各庄|GGP|gaogezhuang|ggz|871@ghe|甘河|GAX|ganhe|gh|872@ghe|根河|GEX|genhe|gh|873@gjd|郭家店|GDT|guojiadian|gjd|874@gjz|孤家子|GKT|gujiazi|gjz|875@gla|古浪|GLJ|gulang|gl|876@gla|皋兰|GEJ|gaolan|gl|877@glf|高楼房|GFM|gaoloufang|glf|878@glh|归流河|GHT|guiliuhe|glh|879@gli|关林|GLF|guanlin|gl|880@glu|甘洛|VOW|ganluo|gl|881@glz|郭磊庄|GLP|guoleizhuang|glz|882@gmi|高密|GMK|gaomi|gm|883@gmz|公庙子|GMC|gongmiaozi|gmz|884@gnh|工农湖|GRT|gongnonghu|gnh|885@gnn|广宁寺南|GNT|guangningsinan|gnn|886@gnw|广南卫|GNM|guangnanwei|gnw|887@gpi|高平|GPF|gaoping|gp|888@gqb|甘泉北|GEY|ganquanbei|gqb|889@gqc|共青城|GAG|gongqingcheng|gqc|890@gqk|甘旗卡|GQD|ganqika|gqk|891@gqu|甘泉|GQY|ganquan|gq|892@gqz|高桥镇|GZD|gaoqiaozhen|gqz|893@gsh|灌水|GST|guanshui|gs|894@gsh|赶水|GSW|ganshui|gs|895@gsk|孤山口|GSP|gushankou|gsk|896@gso|果松|GSL|guosong|gs|897@gsz|高山子|GSD|gaoshanzi|gsz|898@gsz|嘎什甸子|GXD|gashidianzi|gsdz|899@gta|高台|GTJ|gaotai|gt|900@gta|高滩|GAY|gaotan|gt|901@gti|官厅|GTP|guanting|gt|902@gti|古田|GTS|gutian|gt|903@gtx|官厅西|KEP|guantingxi|gtx|904@gxi|贵溪|GXG|guixi|gx|905@gya|涡阳|GYH|guoyang|gy|906@gyi|巩义|GXF|gongyi|gy|907@gyi|高邑|GIP|gaoyi|gy|908@gyn|巩义南|GYF|gongyinan|gyn|909@gyn|广元南|GAW|guangyuannan|gyn|910@gyu|固原|GUJ|guyuan|gy|911@gyu|菇园|GYL|guyuan|gy|912@gyz|公营子|GYD|gongyingzi|gyz|913@gze|光泽|GZS|guangze|gz|914@gzh|固镇|GEH|guzhen|gz|915@gzh|瓜州|GZJ|guazhou|gz|916@gzh|古镇|GNQ|guzhen|gz|917@gzh|高州|GSQ|gaozhou|gz|918@gzh|盖州|GXT|gaizhou|gz|919@gzh|虢镇|GZY|guozhen|gz|920@gzj|官字井|GOT|guanzijing|gzj|921@gzs|冠豸山|GSS|guanzhaishan|gzs|922@gzx|盖州西|GAT|gaizhouxi|gzx|923@han|海安|HIH|haian|ha|924@han|淮安南|AMH|huaiannan|han|925@han|红安|HWN|hongan|ha|926@hax|红安西|VXN|honganxi|hax|927@hba|黄柏|HBL|huangbai|hb|928@hbe|海北|HEB|haibei|hb|929@hbi|鹤壁|HAF|hebi|hb|930@hcb|会昌北|XEG|huichangbei|hcb|931@hch|华城|VCQ|huacheng|hc|932@hch|河唇|HCZ|hechun|hc|933@hch|汉川|HCN|hanchuan|hc|934@hch|海城|HCT|haicheng|hc|935@hch|合川|WKW|hechuan|hc|936@hct|黑冲滩|HCJ|heichongtan|hct|937@hcu|黄村|HCP|huangcun|hc|938@hcx|海城西|HXT|haichengxi|hcx|939@hde|化德|HGC|huade|hd|940@hdo|洪洞|HDV|hongtong|hd|941@hes|霍尔果斯|HFR|huoerguosi|hegs|942@hfe|横峰|HFG|hengfeng|hf|943@hfw|韩府湾|HXJ|hanfuwan|hfw|944@hgu|汉沽|HGP|hangu|hg|945@hgy|黄瓜园|HYM|huangguayuan|hgy|946@hgz|红光镇|IGW|hongguangzhen|hgz|947@hhe|浑河|HHT|hunhe|hh|948@hhg|红花沟|VHD|honghuagou|hhg|949@hht|黄花筒|HUD|huanghuatong|hht|950@hjd|贺家店|HJJ|hejiadian|hjd|951@hji|和静|HJR|hejing|hj|952@hji|获嘉|HJF|huojia|hj|953@hji|河津|HJV|hejin|hj|954@hji|红江|HFM|hongjiang|hj|955@hji|黑井|HIM|heijing|hj|956@hji|涵江|HJS|hanjiang|hj|957@hji|华家|HJT|huajia|hj|958@hjq|杭锦后旗|HDC|hangjinhouqi|hjhq|959@hjx|河间西|HXP|hejianxi|hjx|960@hjz|花家庄|HJM|huajiazhuang|hjz|961@hkn|河口南|HKJ|hekounan|hkn|962@hko|黄口|KOH|huangkou|hk|963@hko|湖口|HKG|hukou|hk|964@hla|呼兰|HUB|hulan|hl|965@hlb|葫芦岛北|HPD|huludaobei|hldb|966@hlh|浩良河|HHB|haolianghe|hlh|967@hlh|哈拉海|HIT|halahai|hlh|968@hli|鹤立|HOB|heli|hl|969@hli|桦林|HIB|hualin|hl|970@hli|海林|HRB|hailin|hl|971@hli|虎林|VLB|hulin|hl|972@hli|黄陵|ULY|huangling|hl|973@hli|寒岭|HAT|hanling|hl|974@hlo|和龙|HLL|helong|hl|975@hlo|海龙|HIL|hailong|hl|976@hls|哈拉苏|HAX|halasu|hls|977@hlt|呼鲁斯太|VTJ|hulusitai|hlst|978@hlz|火连寨|HLT|huolianzhai|hlz|979@hme|黄梅|VEH|huangmei|hm|980@hmy|韩麻营|HYP|hanmaying|hmy|981@hnh|黄泥河|HHL|huangnihe|hnh|982@hni|海宁|HNH|haining|hn|983@hno|惠农|HMJ|huinong|hn|984@hpi|和平|VAQ|heping|hp|985@hpz|花棚子|HZM|huapengzi|hpz|986@hqi|花桥|VQH|huaqiao|hq|987@hqi|宏庆|HEY|hongqing|hq|988@hre|怀仁|HRV|huairen|hr|989@hro|华容|HRN|huarong|hr|990@hsb|华山北|HDY|huashanbei|hsb|991@hsd|黄松甸|HDL|huangsongdian|hsd|992@hsg|和什托洛盖|VSR|heshituoluogai|hstlg|993@hsh|红山|VSB|hongshan|hs|994@hsh|汉寿|VSQ|hanshou|hs|995@hsh|衡山|HSQ|hengshan|hs|996@hsh|黑水|HOT|heishui|hs|997@hsh|惠山|VCH|huishan|hs|998@hsh|虎什哈|HHP|hushiha|hsh|999@hsp|红寺堡|HSJ|hongsipu|hsp|1000@hst|虎石台|HUT|hushitai|hst|1001@hsw|海石湾|HSO|haishiwan|hsw|1002@hsx|衡山西|HEQ|hengshanxi|hsx|1003@hsx|红砂岘|VSJ|hongshaxian|hsx|1004@hta|黑台|HQB|heitai|ht|1005@hta|桓台|VTK|huantai|ht|1006@hti|和田|VTR|hetian|ht|1007@hto|会同|VTQ|huitong|ht|1008@htz|海坨子|HZT|haituozi|htz|1009@hwa|黑旺|HWK|heiwang|hw|1010@hwa|海湾|RWH|haiwan|hw|1011@hxi|红星|VXB|hongxing|hx|1012@hxi|徽县|HYY|huixian|hx|1013@hxl|红兴隆|VHB|hongxinglong|hxl|1014@hxt|换新天|VTB|huanxintian|hxt|1015@hxt|红岘台|HTJ|hongxiantai|hxt|1016@hya|红彦|VIX|hongyan|hy|1017@hya|海晏|HFO|haiyan|hy|1018@hya|合阳|HAY|heyang|hy|1019@hyd|衡阳东|HVQ|hengyangdong|hyd|1020@hyi|华蓥|HUW|huaying|hy|1021@hyi|汉阴|HQY|hanyin|hy|1022@hyt|黄羊滩|HGJ|huangyangtan|hyt|1023@hyu|汉源|WHW|hanyuan|hy|1024@hyu|河源|VIQ|heyuan|hy|1025@hyu|花园|HUN|huayuan|hy|1026@hyu|湟源|HNO|huangyuan|hy|1027@hyz|黄羊镇|HYJ|huangyangzhen|hyz|1028@hzh|湖州|VZH|huzhou|hz|1029@hzh|化州|HZZ|huazhou|hz|1030@hzh|黄州|VON|huangzhou|hz|1031@hzh|霍州|HZV|huozhou|hz|1032@hzx|惠州西|VXQ|huizhouxi|hzx|1033@jba|巨宝|JRT|jubao|jb|1034@jbi|靖边|JIY|jingbian|jb|1035@jbt|金宝屯|JBD|jinbaotun|jbt|1036@jcb|晋城北|JEF|jinchengbei|jcb|1037@jch|金昌|JCJ|jinchang|jc|1038@jch|交城|JNV|jiaocheng|jc|1039@jch|鄄城|JCK|juancheng|jc|1040@jch|建昌|JFD|jianchang|jc|1041@jde|峻德|JDB|junde|jd|1042@jdi|井店|JFP|jingdian|jd|1043@jdo|鸡东|JOB|jidong|jd|1044@jdu|江都|UDH|jiangdu|jd|1045@jgs|鸡冠山|JST|jiguanshan|jgs|1046@jgt|金沟屯|VGP|jingoutun|jgt|1047@jha|静海|JHP|jinghai|jh|1048@jhe|金河|JHX|jinhe|jh|1049@jhe|锦河|JHB|jinhe|jh|1050@jhe|精河|JHR|jinghe|jh|1051@jhn|精河南|JIR|jinghenan|jhn|1052@jhu|江华|JHZ|jianghua|jh|1053@jhu|建湖|AJH|jianhu|jh|1054@jjg|纪家沟|VJD|jijiagou|jjg|1055@jji|晋江|JJS|jinjiang|jj|1056@jji|锦界|JEY|jinjie|jj|1057@jji|姜家|JJB|jiangjia|jj|1058@jji|江津|JJW|jiangjin|jj|1059@jke|金坑|JKT|jinkeng|jk|1060@jli|芨岭|JLJ|jiling|jl|1061@jmc|金马村|JMM|jinmacun|jmc|1062@jmd|江门东|JWQ|jiangmendong|jmd|1063@jme|角美|JES|jiaomei|jm|1064@jna|莒南|JOK|junan|jn|1065@jna|井南|JNP|jingnan|jn|1066@jou|建瓯|JVS|jianou|jo|1067@jpe|经棚|JPC|jingpeng|jp|1068@jqi|江桥|JQX|jiangqiao|jq|1069@jsa|九三|SSX|jiusan|js|1070@jsb|金山北|EGH|jinshanbei|jsb|1071@jsh|嘉善|JSH|jiashan|js|1072@jsh|京山|JCN|jingshan|js|1073@jsh|建始|JRN|jianshi|js|1074@jsh|稷山|JVV|jishan|js|1075@jsh|吉舒|JSL|jishu|js|1076@jsh|建设|JET|jianshe|js|1077@jsh|甲山|JOP|jiashan|js|1078@jsj|建三江|JIB|jiansanjiang|jsj|1079@jsn|嘉善南|EAH|jiashannan|jsn|1080@jst|金山屯|JTB|jinshantun|jst|1081@jst|江所田|JOM|jiangsuotian|jst|1082@jta|景泰|JTJ|jingtai|jt|1083@jtn|九台南|JNL|jiutainan|jtn|1084@jwe|吉文|JWX|jiwen|jw|1085@jxi|进贤|JUG|jinxian|jx|1086@jxi|莒县|JKK|juxian|jx|1087@jxi|嘉祥|JUK|jiaxiang|jx|1088@jxi|介休|JXV|jiexiu|jx|1089@jxi|嘉兴|JXH|jiaxing|jx|1090@jxi|井陉|JJP|jingxing|jx|1091@jxn|嘉兴南|EPH|jiaxingnan|jxn|1092@jxz|夹心子|JXT|jiaxinzi|jxz|1093@jya|简阳|JYW|jianyang|jy|1094@jya|姜堰|UEH|jiangyan|jy|1095@jya|建阳|JYS|jianyang|jy|1096@jye|巨野|JYK|juye|jy|1097@jyn|揭阳南|JRQ|jieyangnan|jyn|1098@jyo|江永|JYZ|jiangyong|jy|1099@jyu|缙云|JYH|jinyun|jy|1100@jyu|靖远|JYJ|jingyuan|jy|1101@jyu|江源|SZL|jiangyuan|jy|1102@jyu|济源|JYF|jiyuan|jy|1103@jyx|靖远西|JXJ|jingyuanxi|jyx|1104@jzb|胶州北|JZK|jiaozhoubei|jzb|1105@jzd|焦作东|WEF|jiaozuodong|jzd|1106@jzh|金寨|JZH|jinzhai|jz|1107@jzh|蓟州|JIP|jizhou|jz|1108@jzh|靖州|JEQ|jingzhou|jz|1109@jzh|荆州|JBN|jingzhou|jz|1110@jzh|胶州|JXK|jiaozhou|jz|1111@jzh|晋州|JXP|jinzhou|jz|1112@jzn|锦州南|JOD|jinzhounan|jzn|1113@jzu|焦作|JOF|jiaozuo|jz|1114@jzw|旧庄窝|JVP|jiuzhuangwo|jzw|1115@jzz|金杖子|JYD|jinzhangzi|jzz|1116@kan|开安|KAT|kaian|ka|1117@kch|库车|KCR|kuche|kc|1118@kch|康城|KCP|kangcheng|kc|1119@kde|库都尔|KDX|kuduer|kde|1120@kdi|宽甸|KDT|kuandian|kd|1121@kdo|克东|KOB|kedong|kd|1122@kdz|昆都仑召|KDC|kundulunzhao|kdlz|1123@kji|开江|KAW|kaijiang|kj|1124@kjj|康金井|KJB|kangjinjing|kjj|1125@klq|喀喇其|KQX|kalaqi|klq|1126@klu|开鲁|KLC|kailu|kl|1127@kly|克拉玛依|KHR|kelamayi|klmy|1128@kpn|开平南|PVQ|kaipingnan|kpn|1129@kqi|口前|KQL|kouqian|kq|1130@ksh|昆山|KSH|kunshan|ks|1131@ksh|奎山|KAB|kuishan|ks|1132@ksh|克山|KSB|keshan|ks|1133@kxl|康熙岭|KXZ|kangxiling|kxl|1134@kya|昆阳|KAM|kunyang|ky|1135@kyh|克一河|KHX|keyihe|kyh|1136@kyx|开原西|KXT|kaiyuanxi|kyx|1137@kzh|康庄|KZP|kangzhuang|kz|1138@lbi|来宾|UBZ|laibin|lb|1139@lbi|老边|LLT|laobian|lb|1140@lbx|灵宝西|LPF|lingbaoxi|lbx|1141@lcd|洛川东|LRY|luochuandong|lcd|1142@lch|龙川|LUQ|longchuan|lc|1143@lch|乐昌|LCQ|lechang|lc|1144@lch|黎城|UCP|licheng|lc|1145@lch|聊城|UCK|liaocheng|lc|1146@lcu|蓝村|LCK|lancun|lc|1147@lda|两当|LDY|liangdang|ld|1148@ldo|林东|LRC|lindong|ld|1149@ldu|乐都|LDO|ledu|ld|1150@ldx|梁底下|LDP|liangdixia|ldx|1151@ldz|六道河子|LVP|liudaohezi|ldhz|1152@lfa|鲁番|LVM|lufan|lf|1153@lfa|廊坊|LJP|langfang|lf|1154@lfa|落垡|LOP|luofa|lf|1155@lfb|廊坊北|LFP|langfangbei|lfb|1156@lfu|老府|UFD|laofu|lf|1157@lga|兰岗|LNB|langang|lg|1158@lgd|龙骨甸|LGM|longgudian|lgd|1159@lgo|芦沟|LOM|lugou|lg|1160@lgo|龙沟|LGJ|longgou|lg|1161@lgu|拉古|LGB|lagu|lg|1162@lha|临海|UFH|linhai|lh|1163@lha|拉哈|LHX|laha|lh|1164@lha|凌海|JID|linghai|lh|1165@lha|林海|LXX|linhai|lh|1166@lhe|柳河|LNL|liuhe|lh|1167@lhe|六合|KLH|liuhe|lh|1168@lhu|龙华|LHP|longhua|lh|1169@lhy|滦河沿|UNP|luanheyan|lhy|1170@lhz|六合镇|LEX|liuhezhen|lhz|1171@ljd|亮甲店|LRT|liangjiadian|ljd|1172@ljd|刘家店|UDT|liujiadian|ljd|1173@ljh|刘家河|LVT|liujiahe|ljh|1174@lji|连江|LKS|lianjiang|lj|1175@lji|庐江|UJH|lujiang|lj|1176@lji|李家|LJB|lijia|lj|1177@lji|廉江|LJZ|lianjiang|lj|1178@lji|两家|UJT|liangjia|lj|1179@lji|龙江|LJX|longjiang|lj|1180@lji|罗江|LJW|luojiang|lj|1181@lji|龙嘉|UJL|longjia|lj|1182@ljk|莲江口|LHB|lianjiangkou|ljk|1183@ljl|蔺家楼|ULK|linjialou|ljl|1184@ljp|李家坪|LIJ|lijiaping|ljp|1185@lka|兰考|LKF|lankao|lk|1186@lko|林口|LKB|linkou|lk|1187@lkp|路口铺|LKQ|lukoupu|lkp|1188@lla|老莱|LAX|laolai|ll|1189@lli|拉林|LAB|lalin|ll|1190@lli|陆良|LRM|luliang|ll|1191@lli|临澧|LWQ|linli|ll|1192@lli|兰棱|LLB|lanling|ll|1193@lli|龙里|LLW|longli|ll|1194@lli|零陵|UWZ|lingling|ll|1195@llo|卢龙|UAP|lulong|ll|1196@lmd|喇嘛甸|LMX|lamadian|lmd|1197@lmd|里木店|LMB|limudian|lmd|1198@lme|洛门|LMJ|luomen|lm|1199@lna|龙南|UNG|longnan|ln|1200@lpi|梁平|UQW|liangping|lp|1201@lpi|罗平|LPM|luoping|lp|1202@lpl|落坡岭|LPP|luopoling|lpl|1203@lps|乐平市|LPG|lepingshi|lps|1204@lps|六盘山|UPJ|liupanshan|lps|1205@lqi|临清|UQK|linqing|lq|1206@lqs|龙泉寺|UQJ|longquansi|lqs|1207@lsb|乐山北|UTW|leshanbei|ls|1208@lsc|乐善村|LUM|leshancun|lsc|1209@lsd|冷水江东|UDQ|lengshuijiangdong|lsjd|1210@lsg|连山关|LGT|lianshanguan|lsg|1211@lsg|流水沟|USP|liushuigou|lsg|1212@lsh|丽水|USH|lishui|ls|1213@lsh|陵水|LIQ|lingshui|ls|1214@lsh|罗山|LRN|luoshan|ls|1215@lsh|鲁山|LAF|lushan|ls|1216@lsh|梁山|LMK|liangshan|ls|1217@lsh|灵石|LSV|lingshi|ls|1218@lsh|露水河|LUL|lushuihe|lsh|1219@lsh|庐山|LSG|lushan|ls|1220@lsp|林盛堡|LBT|linshengpu|lsp|1221@lst|柳树屯|LSD|liushutun|lst|1222@lsz|龙山镇|LAS|longshanzhen|lsz|1223@lsz|梨树镇|LSB|lishuzhen|lsz|1224@lsz|李石寨|LET|lishizhai|lsz|1225@lta|黎塘|LTZ|litang|lt|1226@lta|轮台|LAR|luntai|lt|1227@lta|芦台|LTP|lutai|lt|1228@ltb|龙塘坝|LBM|longtangba|ltb|1229@ltu|濑湍|LVZ|laituan|lt|1230@ltx|骆驼巷|LTJ|luotuoxiang|ltx|1231@lwa|李旺|VLJ|liwang|lw|1232@lwd|莱芜东|LWK|laiwudong|lwd|1233@lws|狼尾山|LRJ|langweishan|lws|1234@lwu|灵武|LNJ|lingwu|lw|1235@lwx|莱芜西|UXK|laiwuxi|lwx|1236@lxi|滦县|UXP|luanxian|lx|1237@lxi|朗乡|LXB|langxiang|lx|1238@lxi|陇县|LXY|longxian|lx|1239@lxi|临湘|LXQ|linxiang|lx|1240@lxi|莱西|LXK|laixi|lx|1241@lxi|林西|LXC|linxi|lx|1242@lxi|芦溪|LUG|luxi|lx|1243@lxi|良乡|LAP|liangxiang|lx|1244@lya|略阳|LYY|lueyang|ly|1245@lya|莱阳|LYK|laiyang|ly|1246@lya|辽阳|LYT|liaoyang|ly|1247@lyd|凌源东|LDD|lingyuandong|lyd|1248@lyd|临沂东|UYK|linyidong|lyd|1249@lyg|连云港|UIH|lianyungang|lyg|1250@lyi|临颍|LNF|linying|ly|1251@lyi|老营|LXL|laoying|ly|1252@lyo|龙游|LMH|longyou|ly|1253@lyu|罗源|LVS|luoyuan|ly|1254@lyu|涟源|LAQ|lianyuan|ly|1255@lyu|涞源|LYP|laiyuan|ly|1256@lyu|林源|LYX|linyuan|ly|1257@lyx|耒阳西|LPQ|leiyangxi|lyx|1258@lze|临泽|LEJ|linze|lz|1259@lzg|龙爪沟|LZT|longzhuagou|lzg|1260@lzh|雷州|UAQ|leizhou|lz|1261@lzh|六枝|LIW|liuzhi|lz|1262@lzh|龙镇|LZA|longzhen|lz|1263@lzh|鹿寨|LIZ|luzhai|lz|1264@lzh|来舟|LZS|laizhou|lz|1265@lzh|拉鲊|LEM|lazha|lz|1266@lzq|兰州新区|LQJ|lanzhouxinqu|lzxq|1267@mas|马鞍山|MAH|maanshan|mas|1268@mba|毛坝|MBY|maoba|mb|1269@mbg|毛坝关|MGY|maobaguan|mbg|1270@mcb|麻城北|MBN|machengbei|mcb|1271@mch|渑池|MCF|mianchi|mc|1272@mch|明城|MCL|mingcheng|mc|1273@mch|庙城|MAP|miaocheng|mc|1274@mcn|渑池南|MNF|mianchinan|mcn|1275@mcp|茅草坪|KPM|maocaoping|mcp|1276@mdh|猛洞河|MUQ|mengdonghe|mdh|1277@mds|磨刀石|MOB|modaoshi|mds|1278@mdu|弥渡|MDF|midu|md|1279@mes|帽儿山|MRB|maoershan|mes|1280@mga|明港|MGN|minggang|mg|1281@mhk|梅河口|MHL|meihekou|mhk|1282@mhu|马皇|MHZ|mahuang|mh|1283@mjg|孟家岗|MGB|mengjiagang|mjg|1284@mla|美兰|MHQ|meilan|ml|1285@mld|汨罗东|MQQ|miluodong|mld|1286@mlh|马莲河|MHB|malianhe|mlh|1287@mli|穆棱|MLB|muling|ml|1288@mli|麻柳|MLY|maliu|ml|1289@mli|茂林|MLD|maolin|ml|1290@mli|茅岭|MLZ|maoling|ml|1291@mli|庙岭|MLL|miaoling|ml|1292@mli|马林|MID|malin|ml|1293@mlo|马龙|MGM|malong|ml|1294@mlt|木里图|MUD|mulitu|mlt|1295@mlu|汨罗|MLQ|miluo|ml|1296@mnh|玛纳斯湖|MNR|manasihu|mnsh|1297@mni|冕宁|UGW|mianning|mn|1298@mpa|沐滂|MPQ|mupang|mp|1299@mqh|马桥河|MQB|maqiaohe|mqh|1300@mqi|闽清|MQS|minqing|mq|1301@mqu|民权|MQF|minquan|mq|1302@msh|麻山|MAB|mashan|ms|1303@msh|眉山|MSW|meishan|ms|1304@msh|明水河|MUT|mingshuihe|msh|1305@msw|漫水湾|MKW|manshuiwan|msw|1306@msz|米沙子|MST|mishazi|msz|1307@msz|茂舍祖|MOM|maoshezu|msz|1308@mta|马踏|PWQ|mata|mt|1309@mxi|美溪|MEB|meixi|mx|1310@mxi|勉县|MVY|mianxian|mx|1311@mya|麻阳|MVQ|mayang|my|1312@myb|密云北|MUP|miyunbei|myb|1313@myi|米易|MMW|miyi|my|1314@myu|墨玉|MUR|moyu|my|1315@myu|麦园|MYS|maiyuan|my|1316@mzh|米脂|MEY|mizhi|mz|1317@mzh|庙庄|MZJ|miaozhuang|mz|1318@mzh|明珠|MFQ|mingzhu|mz|1319@nan|宁安|NAB|ningan|na|1320@nan|农安|NAT|nongan|na|1321@nbs|南博山|NBK|nanboshan|nbs|1322@nch|南仇|NCK|nanqiu|nc|1323@ncs|南城司|NSP|nanchengsi|ncs|1324@ncu|宁村|NCZ|ningcun|nc|1325@nde|宁德|NES|ningde|nd|1326@ngc|南观村|NGP|nanguancun|ngc|1327@ngd|南宫东|NFP|nangongdong|ngd|1328@ngl|南关岭|NLT|nanguanling|ngl|1329@ngu|宁国|NNH|ningguo|ng|1330@nha|宁海|NHH|ninghai|nh|1331@nhb|南华北|NHS|nanhuabei|nhb|1332@nhc|南河川|NHJ|nanhechuan|nhc|1333@nhz|泥河子|NHD|nihezi|nhz|1334@nji|宁家|NVT|ningjia|nj|1335@nji|南靖|NJS|nanjing|nj|1336@nji|牛家|NJB|niujia|nj|1337@nji|能家|NJD|nengjia|nj|1338@nko|南口|NKP|nankou|nk|1339@nkq|南口前|NKT|nankouqian|nkq|1340@nla|南朗|NNQ|nanlang|nl|1341@nli|乃林|NLD|nailin|nl|1342@nlk|尼勒克|NIR|nileke|nlk|1343@nlu|那罗|ULZ|naluo|nl|1344@nlx|宁陵县|NLF|ninglingxian|nlx|1345@nma|奈曼|NMD|naiman|nm|1346@nmi|宁明|NMZ|ningming|nm|1347@nmu|南木|NMX|nanmu|nm|1348@npu|那铺|NPZ|napu|np|1349@nqi|南桥|NQD|nanqiao|nq|1350@nqu|那曲|NQO|naqu|nq|1351@nqu|暖泉|NQJ|nuanquan|nq|1352@nta|南台|NTT|nantai|nt|1353@nto|南头|NOQ|nantou|nt|1354@nwu|宁武|NWV|ningwu|nw|1355@nwz|南湾子|NWP|nanwanzi|nwz|1356@nxb|南翔北|NEH|nanxiangbei|nxb|1357@nxi|宁乡|NXQ|ningxiang|nx|1358@nxi|内乡|NXF|neixiang|nx|1359@nxt|牛心台|NXT|niuxintai|nxt|1360@nyu|南峪|NUP|nanyu|ny|1361@nzg|娘子关|NIP|niangziguan|nzg|1362@nzh|南召|NAF|nanzhao|nz|1363@nzm|南杂木|NZT|nanzamu|nzm|1364@pan|蓬安|PAW|pengan|pa|1365@pan|平安|PAL|pingan|pa|1366@pay|平安驿|PNO|pinganyi|pay|1367@paz|磐安镇|PAJ|pananzhen|paz|1368@paz|平安镇|PZT|pinganzhen|paz|1369@pcd|蒲城东|PEY|puchengdong|pcd|1370@pch|蒲城|PCY|pucheng|pc|1371@pde|裴德|PDB|peide|pd|1372@pdi|偏店|PRP|piandian|pd|1373@pdx|坡底下|PXJ|podixia|pdx|1374@pet|瓢儿屯|PRT|piaoertun|pet|1375@pfa|平房|PFB|pingfang|pf|1376@pga|平岗|PGL|pinggang|pg|1377@pgu|平果|PGZ|pingguo|pg|1378@pgu|平关|PGM|pingguan|pg|1379@pgu|盘关|PAM|panguan|pg|1380@phb|徘徊北|PHP|paihuaibei|phb|1381@phk|平河口|PHM|pinghekou|phk|1382@phu|平湖|PHQ|pinghu|ph|1383@pjb|盘锦北|PBD|panjinbei|pjb|1384@pjd|潘家店|PDP|panjiadian|pjd|1385@pkn|皮口南|PKT|pikounan|pk|1386@pld|普兰店|PLT|pulandian|pld|1387@pli|偏岭|PNT|pianling|pl|1388@psh|平山|PSB|pingshan|ps|1389@psh|彭山|PSW|pengshan|ps|1390@psh|皮山|PSR|pishan|ps|1391@psh|磐石|PSL|panshi|ps|1392@psh|平社|PSV|pingshe|ps|1393@psh|彭水|PHW|pengshui|ps|1394@pta|平台|PVT|pingtai|pt|1395@pti|平田|PTM|pingtian|pt|1396@pti|莆田|PTS|putian|pt|1397@ptq|葡萄菁|PTW|putaojing|ptq|1398@pwa|平旺|PWV|pingwang|pw|1399@pwa|普湾|PWT|puwan|pw|1400@pxg|平型关|PGV|pingxingguan|pxg|1401@pxi|普雄|POW|puxiong|px|1402@pxi|蓬溪|KZW|pengxi|px|1403@pxi|郫县|PWW|pixian|px|1404@pya|平阳|ARH|pingyang|py|1405@pya|平洋|PYX|pingyang|py|1406@pya|平遥|PYV|pingyao|py|1407@pya|彭阳|PYJ|pengyang|py|1408@pyi|平邑|PIK|pingyi|py|1409@pyp|平原堡|PPJ|pingyuanpu|pyp|1410@pyu|平原|PYK|pingyuan|py|1411@pyu|平峪|PYP|pingyu|py|1412@pzb|平庄北|PZD|pingzhuangbei|pzb|1413@pze|彭泽|PZG|pengze|pz|1414@pzh|邳州|PJH|pizhou|pz|1415@pzi|泡子|POD|paozi|pz|1416@pzn|平庄南|PND|pingzhuangnan|pzn|1417@qan|乾安|QOT|qianan|qa|1418@qan|庆安|QAB|qingan|qa|1419@qan|迁安|QQP|qianan|qa|1420@qdb|祁东北|QRQ|qidongbei|qd|1421@qdi|七甸|QDM|qidian|qd|1422@qfd|曲阜东|QAK|qufudong|qfd|1423@qfe|庆丰|QFT|qingfeng|qf|1424@qft|奇峰塔|QVP|qifengta|qft|1425@qfu|曲阜|QFK|qufu|qf|1426@qha|琼海|QYQ|qionghai|qh|1427@qhd|秦皇岛|QTP|qinhuangdao|qhd|1428@qhe|千河|QUY|qianhe|qh|1429@qhe|清河|QIP|qinghe|qh|1430@qhm|清河门|QHD|qinghemen|qhm|1431@qhy|清华园|QHP|qinghuayuan|qhy|1432@qji|全椒|INH|quanjiao|qj|1433@qji|渠旧|QJZ|qujiu|qj|1434@qji|潜江|QJN|qianjiang|qj|1435@qji|秦家|QJB|qinjia|qj|1436@qji|綦江|QJW|qijiang|qj|1437@qjp|祁家堡|QBT|qijiapu|qjp|1438@qjx|清涧县|QNY|qingjianxian|qjx|1439@qjz|秦家庄|QZV|qinjiazhuang|qjz|1440@qlh|七里河|QLD|qilihe|qlh|1441@qli|秦岭|QLY|qinling|ql|1442@qli|渠黎|QLZ|quli|ql|1443@qlo|青龙|QIB|qinglong|ql|1444@qls|青龙山|QGH|qinglongshan|qls|1445@qme|祁门|QIH|qimen|qm|1446@qmt|前磨头|QMP|qianmotou|qmt|1447@qsh|确山|QSN|queshan|qs|1448@qsh|青山|QSB|qingshan|qs|1449@qsh|清水|QUJ|qingshui|qs|1450@qsh|前山|QXQ|qianshan|qs|1451@qsy|戚墅堰|QYH|qishuyan|qsy|1452@qti|青田|QVH|qingtian|qt|1453@qto|桥头|QAT|qiaotou|qt|1454@qtx|青铜峡|QTJ|qingtongxia|qtx|1455@qwe|前卫|QWD|qianwei|qw|1456@qwt|前苇塘|QWP|qianweitang|qwt|1457@qxi|渠县|QRW|quxian|qx|1458@qxi|祁县|QXV|qixian|qx|1459@qxi|青县|QXP|qingxian|qx|1460@qxi|桥西|QXJ|qiaoxi|qx|1461@qxu|清徐|QUV|qingxu|qx|1462@qxy|旗下营|QXC|qixiaying|qxy|1463@qya|千阳|QOY|qianyang|qy|1464@qya|泉阳|QYL|quanyang|qy|1465@qya|沁阳|QYF|qinyang|qy|1466@qyb|祁阳北|QVQ|qiyangbei|qy|1467@qyi|七营|QYJ|qiying|qy|1468@qys|庆阳山|QSJ|qingyangshan|qys|1469@qyu|清远|QBQ|qingyuan|qy|1470@qyu|清原|QYT|qingyuan|qy|1471@qzd|钦州东|QDZ|qinzhoudong|qzd|1472@qzh|钦州|QRZ|qinzhou|qz|1473@qzs|青州市|QZK|qingzhoushi|qzs|1474@ran|瑞安|RAH|ruian|ra|1475@rch|荣昌|RCW|rongchang|rc|1476@rch|瑞昌|RCG|ruichang|rc|1477@rga|如皋|RBH|rugao|rg|1478@rgu|容桂|RUQ|ronggui|rg|1479@rqi|任丘|RQP|renqiu|rq|1480@rsh|乳山|ROK|rushan|rs|1481@rsh|融水|RSZ|rongshui|rs|1482@rsh|热水|RSD|reshui|rs|1483@rxi|容县|RXZ|rongxian|rx|1484@rya|饶阳|RVP|raoyang|ry|1485@rya|汝阳|RYF|ruyang|ry|1486@ryh|绕阳河|RHD|raoyanghe|ryh|1487@rzh|汝州|ROF|ruzhou|rz|1488@sba|石坝|OBJ|shiba|sb|1489@sbc|上板城|SBP|shangbancheng|sbc|1490@sbi|施秉|AQW|shibing|sb|1491@sbn|上板城南|OBP|shangbanchengnan|sbcn|1492@sby|世博园|ZWT|shiboyuan|sby|1493@scb|双城北|SBB|shuangchengbei|scb|1494@sch|舒城|OCH|shucheng|sc|1495@sch|商城|SWN|shangcheng|sc|1496");
		buf.append("@sch|莎车|SCR|shache|sc|1497@sch|顺昌|SCS|shunchang|sc|1498@sch|沙城|SCP|shacheng|sc|1499@sch|神池|SMV|shenchi|sc|1500@sch|石城|SCT|shicheng|sc|1501@scz|山城镇|SCL|shanchengzhen|scz|1502@sda|山丹|SDJ|shandan|sd|1503@sde|绥德|ODY|suide|sd|1504@sde|顺德|ORQ|shunde|sd|1505@sdo|水洞|SIL|shuidong|sd|1506@sdu|商都|SXC|shangdu|sd|1507@sdu|十渡|SEP|shidu|sd|1508@sdw|四道湾|OUD|sidaowan|sdw|1509@sdy|顺德学院|OJQ|shundexueyuan|sdxy|1510@sfa|绅坊|OLH|shenfang|sf|1511@sfe|双丰|OFB|shuangfeng|sf|1512@sft|四方台|STB|sifangtai|sft|1513@sfu|水富|OTW|shuifu|sf|1514@sgk|三关口|OKJ|sanguankou|sgk|1515@sgl|桑根达来|OGC|sanggendalai|sgdl|1516@sgu|韶关|SNQ|shaoguan|sg|1517@sgz|上高镇|SVK|shanggaozhen|sgz|1518@sha|沙海|SED|shahai|sh|1519@sha|上杭|JBS|shanghang|sh|1520@she|蜀河|SHY|shuhe|sh|1521@she|松河|SBM|songhe|sh|1522@she|沙河|SHP|shahe|sh|1523@shk|沙河口|SKT|shahekou|shk|1524@shl|赛汗塔拉|SHC|saihantala|shtl|1525@shs|沙河市|VOP|shaheshi|shs|1526@shs|沙后所|SSD|shahousuo|shs|1527@sht|山河屯|SHL|shanhetun|sht|1528@shx|三河县|OXP|sanhexian|shx|1529@shy|四合永|OHD|siheyong|shy|1530@shz|双河镇|SEL|shuanghezhen|shz|1531@shz|三汇镇|OZW|sanhuizhen|shz|1532@shz|石河子|SZR|shihezi|shz|1533@shz|三合庄|SVP|sanhezhuang|shz|1534@sjd|三家店|ODP|sanjiadian|sjd|1535@sjh|水家湖|SQH|shuijiahu|sjh|1536@sjh|松江河|SJL|songjianghe|sjh|1537@sjh|沈家河|OJJ|shenjiahe|sjh|1538@sji|孙家|SUB|sunjia|sj|1539@sji|沈家|OJB|shenjia|sj|1540@sji|尚家|SJB|shangjia|sj|1541@sji|双吉|SML|shuangji|sj|1542@sji|松江|SAH|songjiang|sj|1543@sjk|三江口|SKD|sanjiangkou|sjk|1544@sjl|司家岭|OLK|sijialing|sjl|1545@sjn|松江南|IMH|songjiangnan|sjn|1546@sjn|石景山南|SRP|shijingshannan|sjsn|1547@sjt|邵家堂|SJJ|shaojiatang|sjt|1548@sjx|三江县|SOZ|sanjiangxian|sjx|1549@sjz|松江镇|OZL|songjiangzhen|sjz|1550@sjz|三家寨|SMM|sanjiazhai|sjz|1551@sjz|十家子|SJD|shijiazi|sjz|1552@sjz|深井子|SWT|shenjingzi|sjz|1553@sjz|施家嘴|SHM|shijiazui|sjz|1554@sld|什里店|OMP|shilidian|sld|1555@sle|疏勒|SUR|shule|sl|1556@slh|疏勒河|SHJ|shulehe|slh|1557@slh|舍力虎|VLD|shelihu|slh|1558@sli|石磷|SPB|shilin|sl|1559@sli|石林|SLM|shilin|sl|1560@sli|双辽|ZJD|shuangliao|sl|1561@sli|绥棱|SIB|suiling|sl|1562@sli|石岭|SOL|shiling|sl|1563@sln|石林南|LNM|shilinnan|sln|1564@slo|石龙|SLQ|shilong|sl|1565@slq|萨拉齐|SLC|salaqi|slq|1566@slu|索伦|SNT|suolun|sl|1567@slu|商洛|OLY|shangluo|sl|1568@slz|沙岭子|SLP|shalingzi|slz|1569@smb|石门县北|VFQ|shimenxianbei|smxb|1570@smn|三门峡南|SCF|sanmenxianan|smxn|1571@smx|三门县|OQH|sanmenxian|smx|1572@smx|神木西|OUY|shenmuxi|smx|1573@smx|三门峡西|SXF|sanmenxiaxi|smxx|1574@smx|石门县|OMQ|shimenxian|smx|1575@sni|肃宁|SYP|suning|sn|1576@son|宋|SOB|song|son|1577@spa|双牌|SBZ|shuangpai|sp|1578@spb|沙坪坝|CYW|shapingba|spb|1579@spd|四平东|PPT|sipingdong|spd|1580@spi|遂平|SON|suiping|sp|1581@spt|沙坡头|SFJ|shapotou|spt|1582@sqi|沙桥|SQM|shaqiao|sq|1583@sqn|商丘南|SPF|shangqiunan|sqn|1584@squ|水泉|SID|shuiquan|sq|1585@sqx|石泉县|SXY|shiquanxian|sqx|1586@sqz|石桥子|SQT|shiqiaozi|sqz|1587@src|石人城|SRB|shirencheng|src|1588@sre|石人|SRL|shiren|sr|1589@ssh|山市|SQB|shanshi|ss|1590@ssh|神树|SWB|shenshu|ss|1591@ssh|鄯善|SSR|shanshan|ss|1592@ssh|三水|SJQ|sanshui|ss|1593@ssh|泗水|OSK|sishui|ss|1594@ssh|松树|SFT|songshu|ss|1595@ssh|石山|SAD|shishan|ss|1596@ssh|首山|SAT|shoushan|ss|1597@ssj|三十家|SRD|sanshijia|ssj|1598@ssp|三十里堡|SST|sanshilipu|sslp|1599@ssz|双水镇|PQQ|shuangshuizhen|ssz|1600@ssz|松树镇|SSL|songshuzhen|ssz|1601@sta|松桃|MZQ|songtao|st|1602@sth|索图罕|SHX|suotuhan|sth|1603@stj|三堂集|SDH|santangji|stj|1604@sto|石头|OTB|shitou|st|1605@sto|神头|SEV|shentou|st|1606@stu|沙沱|SFM|shatuo|st|1607@swa|上万|SWP|shangwan|sw|1608@swu|孙吴|SKB|sunwu|sw|1609@swx|沙湾县|SXR|shawanxian|swx|1610@sxi|歙县|OVH|shexian|sx|1611@sxi|遂溪|SXZ|suixi|sx|1612@sxi|沙县|SAS|shaxian|sx|1613@sxi|绍兴|SOH|shaoxing|sx|1614@sxi|石岘|SXL|shixian|sx|1615@sxp|上西铺|SXM|shangxipu|sxp|1616@sxz|石峡子|SXJ|shixiazi|sxz|1617@sya|绥阳|SYB|suiyang|sy|1618@sya|沭阳|FMH|shuyang|sy|1619@sya|寿阳|SYV|shouyang|sy|1620@sya|水洋|OYP|shuiyang|sy|1621@syc|三阳川|SYJ|sanyangchuan|syc|1622@syd|上腰墩|SPJ|shangyaodun|syd|1623@syi|三营|OEJ|sanying|sy|1624@syi|顺义|SOP|shunyi|sy|1625@syj|三义井|OYD|sanyijing|syj|1626@syp|三源浦|SYL|sanyuanpu|syp|1627@syu|上虞|BDH|shangyu|sy|1628@syu|三原|SAY|sanyuan|sy|1629@syu|上园|SUD|shangyuan|sy|1630@syu|水源|OYJ|shuiyuan|sy|1631@syz|桑园子|SAJ|sangyuanzi|syz|1632@szb|绥中北|SND|suizhongbei|szb|1633@szb|苏州北|OHH|suzhoubei|szb|1634@szd|宿州东|SRH|suzhoudong|szd|1635@szd|深圳东|BJQ|shenzhendong|szd|1636@szh|深州|OZP|shenzhou|sz|1637@szh|绥中|SZD|suizhong|sz|1638@szh|尚志|SZB|shangzhi|sz|1639@szh|孙镇|OZY|sunzhen|sz|1640@szh|师庄|SNM|shizhuang|sz|1641@szi|松滋|SIN|songzi|sz|1642@szo|师宗|SEM|shizong|sz|1643@szq|苏州园区|KAH|suzhouyuanqu|szyq|1644@szq|苏州新区|ITH|suzhouxinqu|szxq|1645@tan|泰安|TMK|taian|ta|1646@tan|台安|TID|taian|ta|1647@tay|通安驿|TAJ|tonganyi|tay|1648@tba|桐柏|TBF|tongbai|tb|1649@tbe|通北|TBB|tongbei|tb|1650@tch|桐城|TTH|tongcheng|tc|1651@tch|汤池|TCX|tangchi|tc|1652@tch|郯城|TZK|tancheng|tc|1653@tch|铁厂|TCL|tiechang|tc|1654@tcu|桃村|TCK|taocun|tc|1655@tda|通道|TRQ|tongdao|td|1656@tdo|田东|TDZ|tiandong|td|1657@tga|天岗|TGL|tiangang|tg|1658@tgl|土贵乌拉|TGC|tuguiwula|tgwl|1659@tgo|通沟|TOL|tonggou|tg|1660@tgu|太谷|TGV|taigu|tg|1661@tha|塔哈|THX|taha|th|1662@tha|棠海|THM|tanghai|th|1663@the|唐河|THF|tanghe|th|1664@the|泰和|THG|taihe|th|1665@thu|太湖|TKH|taihu|th|1666@tji|团结|TIX|tuanjie|tj|1667@tjj|谭家井|TNJ|tanjiajing|tjj|1668@tjt|陶家屯|TOT|taojiatun|tjt|1669@tjw|唐家湾|PDQ|tangjiawan|tjw|1670@tjz|统军庄|TZP|tongjunzhuang|tjz|1671@tld|吐列毛杜|TMD|tuliemaodu|tlmd|1672@tlh|图里河|TEX|tulihe|tlh|1673@tli|铜陵|TJH|tongling|tl|1674@tli|田林|TFZ|tianlin|tl|1675@tli|亭亮|TIZ|tingliang|tl|1676@tli|铁力|TLB|tieli|tl|1677@tlx|铁岭西|PXT|tielingxi|tlx|1678@tmb|图们北|QSL|tumenbei|tmb|1679@tme|天门|TMN|tianmen|tm|1680@tmn|天门南|TNN|tianmennan|tmn|1681@tms|太姥山|TLS|taimushan|tms|1682@tmt|土牧尔台|TRC|tumuertai|tmet|1683@tmz|土门子|TCJ|tumenzi|tmz|1684@tna|洮南|TVT|taonan|tn|1685@tna|潼南|TVW|tongnan|tn|1686@tpc|太平川|TIT|taipingchuan|tpc|1687@tpz|太平镇|TEB|taipingzhen|tpz|1688@tqi|图强|TQX|tuqiang|tq|1689@tqi|台前|TTK|taiqian|tq|1690@tql|天桥岭|TQL|tianqiaoling|tql|1691@tqz|土桥子|TQJ|tuqiaozi|tqz|1692@tsc|汤山城|TCT|tangshancheng|tsc|1693@tsh|桃山|TAB|taoshan|ts|1694@tsh|台山|PUQ|taishan|ts|1695@tsz|塔石嘴|TIM|tashizui|tsz|1696@ttu|通途|TUT|tongtu|tt|1697@twh|汤旺河|THB|tangwanghe|twh|1698@txi|同心|TXJ|tongxin|tx|1699@txi|土溪|TSW|tuxi|tx|1700@txi|桐乡|TCH|tongxiang|tx|1701@tya|田阳|TRZ|tianyang|ty|1702@tyi|天义|TND|tianyi|ty|1703@tyi|汤阴|TYF|tangyin|ty|1704@tyl|驼腰岭|TIL|tuoyaoling|tyl|1705@tys|太阳山|TYJ|taiyangshan|tys|1706@tyu|通榆|KTT|tongyu|ty|1707@tyu|汤原|TYB|tangyuan|ty|1708@tyy|塔崖驿|TYP|tayayi|tyy|1709@tzd|滕州东|TEK|tengzhoudong|tzd|1710@tzh|台州|TZH|taizhou|tz|1711@tzh|天祝|TZJ|tianzhu|tz|1712@tzh|滕州|TXK|tengzhou|tz|1713@tzh|天镇|TZV|tianzhen|tz|1714@tzl|桐子林|TEW|tongzilin|tzl|1715@tzs|天柱山|QWH|tianzhushan|tzs|1716@wan|武安|WAP|wuan|wa|1717@wan|文安|WBP|wenan|wa|1718@waz|王安镇|WVP|wanganzhen|waz|1719@wbu|吴堡|WUY|wubu|wb|1720@wca|旺苍|WEW|wangcang|wc|1721@wcg|五叉沟|WCT|wuchagou|wcg|1722@wch|温春|WDB|wenchun|wc|1723@wch|文昌|WEQ|wenchang|wc|1724@wdc|五大连池|WRB|wudalianchi|wdlc|1725@wde|文登|WBK|wendeng|wd|1726@wdg|五道沟|WDL|wudaogou|wdg|1727@wdh|五道河|WHP|wudaohe|wdh|1728@wdi|文地|WNZ|wendi|wd|1729@wdo|卫东|WVT|weidong|wd|1730@wds|武当山|WRN|wudangshan|wds|1731@wdu|望都|WDP|wangdu|wd|1732@weh|乌尔旗汗|WHX|wuerqihan|weqh|1733@wfa|潍坊|WFK|weifang|wf|1734@wft|万发屯|WFB|wanfatun|wft|1735@wfu|王府|WUT|wangfu|wf|1736@wfx|瓦房店西|WXT|wafangdianxi|wfdx|1737@wga|王岗|WGB|wanggang|wg|1738@wgo|武功|WGY|wugong|wg|1739@wgo|湾沟|WGL|wangou|wg|1740@wgt|吴官田|WGM|wuguantian|wgt|1741@wha|乌海|WVC|wuhai|wh|1742@whe|苇河|WHB|weihe|wh|1743@whu|卫辉|WHF|weihui|wh|1744@wjc|吴家川|WCJ|wujiachuan|wjc|1745@wji|五家|WUB|wujia|wj|1746@wji|威箐|WAM|weiqing|wj|1747@wji|午汲|WJP|wuji|wj|1748@wji|渭津|WJL|weijin|wj|1749@wjw|王家湾|WJJ|wangjiawan|wjw|1750@wke|倭肯|WQB|woken|wk|1751@wks|五棵树|WKT|wukeshu|wks|1752@wlb|五龙背|WBT|wulongbei|wlb|1753@wle|万乐|WEB|wanle|wl|1754@wlg|瓦拉干|WVX|walagan|wlg|1755@wli|温岭|VHH|wenling|wl|1756@wli|五莲|WLK|wulian|wl|1757@wlq|乌拉特前旗|WQC|wulateqianqi|wltqq|1758@wlt|卧里屯|WLX|wolitun|wlt|1759@wnb|渭南北|WBY|weinanbei|wnb|1760@wne|乌奴耳|WRX|wunuer|wne|1761@wni|万宁|WNQ|wanning|wn|1762@wni|万年|WWG|wannian|wn|1763@wnn|渭南南|WVY|weinannan|wnn|1764@wnz|渭南镇|WNJ|weinanzhen|wnz|1765@wpi|沃皮|WPT|wopi|wp|1766@wqi|吴桥|WUP|wuqiao|wq|1767@wqi|汪清|WQL|wangqing|wq|1768@wqi|武清|WWP|wuqing|wq|1769@wsh|武山|WSJ|wushan|ws|1770@wsh|文水|WEV|wenshui|ws|1771@wsz|魏善庄|WSP|weishanzhuang|wsz|1772@wto|王瞳|WTP|wangtong|wt|1773@wts|五台山|WSV|wutaishan|wts|1774@wtz|王团庄|WZJ|wangtuanzhuang|wtz|1775@wwu|五五|WVR|wuwu|ww|1776@wxd|武乡东|WVV|wuxiangdong|wxd|1777@wxd|无锡东|WGH|wuxidong|wxd|1778@wxi|卫星|WVB|weixing|wx|1779@wxi|闻喜|WXV|wenxi|wx|1780@wxq|无锡新区|IFH|wuxixinqu|wxxq|1781@wxu|武穴|WXN|wuxue|wx|1782@wxu|吴圩|WYZ|wuxu|wx|1783@wya|王杨|WYB|wangyang|wy|1784@wyi|武义|RYH|wuyi|wy|1785@wyi|五营|WWB|wuying|wy|1786@wyt|瓦窑田|WIM|wayaotian|wyt|1787@wyu|五原|WYC|wuyuan|wy|1788@wzg|苇子沟|WZL|weizigou|wzg|1789@wzh|韦庄|WZY|weizhuang|wz|1790@wzh|五寨|WZV|wuzhai|wz|1791@wzt|王兆屯|WZB|wangzhaotun|wzt|1792@wzz|微子镇|WQP|weizizhen|wzz|1793@wzz|魏杖子|WKD|weizhangzi|wzz|1794@xan|新安|EAM|xinan|xa|1795@xan|兴安|XAZ|xingan|xa|1796@xax|新安县|XAF|xinanxian|xax|1797@xba|新保安|XAP|xinbaoan|xba|1798@xbc|下板城|EBP|xiabancheng|xbc|1799@xbl|西八里|XLP|xibali|xbl|1800@xch|宣城|ECH|xuancheng|xc|1801@xch|兴城|XCD|xingcheng|xc|1802@xcu|小村|XEM|xiaocun|xc|1803@xcy|新绰源|XRX|xinchuoyuan|xcy|1804@xcz|下城子|XCB|xiachengzi|xcz|1805@xcz|新城子|XCT|xinchengzi|xcz|1806@xde|喜德|EDW|xide|xd|1807@xdj|小得江|EJM|xiaodejiang|xdj|1808@xdm|西大庙|XMP|xidamiao|xdm|1809@xdo|小东|XOD|xiaodong|xd|1810@xdo|小董|XEZ|xiaodong|xd|1811@xfa|香坊|XFB|xiangfang|xf|1812@xfe|信丰|EFG|xinfeng|xf|1813@xfe|襄汾|XFV|xiangfen|xf|1814@xfe|息烽|XFW|xifeng|xf|1815@xga|新干|EGG|xingan|xg|1816@xga|轩岗|XGV|xuangang|xg|1817@xga|孝感|XGN|xiaogan|xg|1818@xgc|西固城|XUJ|xigucheng|xgc|1819@xgu|兴国|EUG|xingguo|xg|1820@xgu|西固|XIJ|xigu|xg|1821@xgy|夏官营|XGJ|xiaguanying|xgy|1822@xgz|西岗子|NBB|xigangzi|xgz|1823@xha|宣汉|XHY|xuanhan|xh|1824@xhe|新和|XIR|xinhe|xh|1825@xhe|襄河|XXB|xianghe|xh|1826@xhe|宣和|XWJ|xuanhe|xh|1827@xhj|斜河涧|EEP|xiehejian|xhj|1828@xht|新华屯|XAX|xinhuatun|xht|1829@xhu|新华|XHB|xinhua|xh|1830@xhu|新会|EFQ|xinhui|xh|1831@xhu|新晃|XLQ|xinhuang|xh|1832@xhu|新化|EHQ|xinhua|xh|1833@xhu|宣化|XHP|xuanhua|xh|1834@xhx|兴和西|XEC|xinghexi|xhx|1835@xhy|下花园|XYP|xiahuayuan|xhy|1836@xhy|小河沿|XYD|xiaoheyan|xhy|1837@xhz|小河镇|EKY|xiaohezhen|xhz|1838@xjd|徐家店|HYK|xujiadian|xjd|1839@xji|峡江|EJG|xiajiang|xj|1840@xji|新绛|XJV|xinjiang|xj|1841@xji|辛集|ENP|xinji|xj|1842@xji|徐家|XJB|xujia|xj|1843@xji|新江|XJM|xinjiang|xj|1844@xjk|西街口|EKM|xijiekou|xjk|1845@xjt|许家屯|XJT|xujiatun|xjt|1846@xjt|许家台|XTJ|xujiatai|xjt|1847@xjz|谢家镇|XMT|xiejiazhen|xjz|1848@xka|兴凯|EKB|xingkai|xk|1849@xla|香兰|XNB|xianglan|xl|1850@xla|小榄|EAQ|xiaolan|xl|1851@xld|兴隆店|XDD|xinglongdian|xld|1852@xle|新乐|ELP|xinle|xl|1853@xli|新林|XPX|xinlin|xl|1854@xli|小岭|XLB|xiaoling|xl|1855@xli|西林|XYB|xilin|xl|1856@xli|西柳|GCT|xiliu|xl|1857@xli|新李|XLJ|xinli|xl|1858@xli|仙林|XPH|xianlin|xl|1859@xlt|新立屯|XLD|xinlitun|xlt|1860@xlx|兴隆县|EXP|xinglongxian|xlx|1861@xlz|兴隆镇|XZB|xinglongzhen|xlz|1862@xlz|新立镇|XGT|xinlizhen|xlz|1863@xmi|新民|XMD|xinmin|xm|1864@xms|西麻山|XMB|ximashan|xms|1865@xmt|下马塘|XAT|xiamatang|xmt|1866@xna|孝南|XNV|xiaonan|xn|1867@xnb|咸宁北|XRN|xianningbei|xnb|1868@xni|兴宁|ENQ|xingning|xn|1869@xni|咸宁|XNN|xianning|xn|1870@xpd|犀浦东|XAW|xipudong|xpd|1871@xpi|西平|XPN|xiping|xp|1872@xpi|兴平|XPY|xingping|xp|1873@xpt|新坪田|XPM|xinpingtian|xpt|1874@xpu|霞浦|XOS|xiapu|xp|1875@xpu|溆浦|EPQ|xupu|xp|1876@xpu|犀浦|XIW|xipu|xp|1877@xqi|新青|XQB|xinqing|xq|1878@xqi|新邱|XQD|xinqiu|xq|1879@xqp|兴泉堡|XQJ|xingquanbu|xqp|1880@xrq|仙人桥|XRL|xianrenqiao|xrq|1881@xsg|小寺沟|ESP|xiaosigou|xsg|1882@xsh|浠水|XZN|xishui|xs|1883@xsh|小市|XST|xiaoshi|xs|1884@xsh|杏树|XSB|xingshu|xs|1885@xsh|下社|XSV|xiashe|xs|1886@xsh|徐水|XSP|xushui|xs|1887@xsh|夏石|XIZ|xiashi|xs|1888@xsh|秀山|ETW|xiushan|xs|1889@xsh|小哨|XAM|xiaoshao|xs|1890@xsp|新松浦|XOB|xinsongpu|xsp|1891@xst|杏树屯|XDT|xingshutun|xst|1892@xsw|许三湾|XSJ|xusanwan|xsw|1893@xta|湘潭|XTQ|xiangtan|xt|1894@xta|邢台|XTP|xingtai|xt|1895@xta|向塘|XTG|xiangtang|xt|1896@xtx|仙桃西|XAN|xiantaoxi|xtx|1897@xtz|下台子|EIP|xiataizi|xtz|1898@xwe|徐闻|XJQ|xuwen|xw|1899@xwp|新窝铺|EPD|xinwopu|xwp|1900@xwu|修武|XWF|xiuwu|xw|1901@xxi|新县|XSN|xinxian|xx|1902@xxi|息县|ENN|xixian|xx|1903@xxi|西乡|XQY|xixiang|xx|1904@xxi|湘乡|XXQ|xiangxiang|xx|1905@xxi|西峡|XIF|xixia|xx|1906@xxi|孝西|XOV|xiaoxi|xx|1907@xxj|小新街|XXM|xiaoxinjie|xxj|1908@xxx|新兴县|XGQ|xinxingxian|xxx|1909@xxz|西小召|XZC|xixiaozhao|xxz|1910@xxz|小西庄|XXP|xiaoxizhuang|xxz|1911@xya|向阳|XDB|xiangyang|xy|1912@xya|旬阳|XUY|xunyang|xy|1913@xyb|旬阳北|XBY|xunyangbei|xyb|1914@xye|兴业|SNZ|xingye|xy|1915@xyg|小雨谷|XHM|xiaoyugu|xyg|1916@xyi|新沂|VIH|xinyi|xy|1917@xyi|兴义|XRZ|xingyi|xy|1918@xyi|信宜|EEQ|xinyi|xy|1919@xyj|小月旧|XFM|xiaoyuejiu|xyj|1920@xyq|小扬气|XYX|xiaoyangqi|xyq|1921@xyu|襄垣|EIF|xiangyuan|xy|1922@xyx|夏邑县|EJH|xiayixian|xyx|1923@xyx|祥云西|EXM|xiangyunxi|xyx|1924@xyy|新友谊|EYB|xinyouyi|xyy|1925@xyz|新阳镇|XZJ|xinyangzhen|xyz|1926@xzd|徐州东|UUH|xuzhoudong|xzd|1927@xzf|新帐房|XZX|xinzhangfang|xzf|1928@xzh|新肇|XZT|xinzhao|xz|1929@xzh|悬钟|XRP|xuanzhong|xz|1930@xzh|襄州|XWN|xiangzhou|xz|1931@xzh|忻州|XXV|xinzhou|xz|1932@xzi|汐子|XZD|xizi|xz|1933@xzm|西哲里木|XRD|xizhelimu|xzlm|1934@xzz|新杖子|ERP|xinzhangzi|xzz|1935@yan|依安|YAX|yian|ya|1936@yan|姚安|YAC|yaoan|ya|1937@yan|永安|YAS|yongan|ya|1938@yax|永安乡|YNB|yonganxiang|yax|1939@ybl|亚布力|YBB|yabuli|ybl|1940@ybs|元宝山|YUD|yuanbaoshan|ybs|1941@yca|羊草|YAB|yangcao|yc|1942@ycd|秧草地|YKM|yangcaodi|ycd|1943@ych|阳澄湖|AIH|yangchenghu|ych|1944@ych|迎春|YYB|yingchun|yc|1945@ych|叶城|YER|yecheng|yc|1946@ych|盐池|YKJ|yanchi|yc|1947@ych|砚川|YYY|yanchuan|yc|1948@ych|阳春|YQQ|yangchun|yc|1949@ych|宜城|YIN|yicheng|yc|1950@ych|应城|YHN|yingcheng|yc|1951@ych|禹城|YCK|yucheng|yc|1952@ych|晏城|YEK|yancheng|yc|1953@ych|阳岔|YAL|yangcha|yc|1954@ych|阳城|YNF|yangcheng|yc|1955@ych|郓城|YPK|yuncheng|yc|1956@ych|雁翅|YAP|yanchi|yc|1957@ycl|云彩岭|ACP|yuncailing|ycl|1958@ycx|虞城县|IXH|yuchengxian|ycx|1959@ycz|营城子|YCT|yingchengzi|ycz|1960@yde|英德|YDQ|yingde|yd|1961@yde|永登|YDJ|yongdeng|yd|1962@ydi|永定|YGS|yongding|yd|1963@ydi|尹地|YDM|yindi|yd|1964@ydo|阳东|WLQ|yangdong|yd|1965@yds|雁荡山|YGH|yandangshan|yds|1966@ydu|于都|YDG|yudu|yd|1967@ydu|园墩|YAJ|yuandun|yd|1968@ydx|英德西|IIQ|yingdexi|ydx|1969@yfy|永丰营|YYM|yongfengying|yfy|1970@yga|杨岗|YRB|yanggang|yg|1971@yga|阳高|YOV|yanggao|yg|1972@ygu|阳谷|YIK|yanggu|yg|1973@yha|友好|YOB|youhao|yh|1974@yha|余杭|EVH|yuhang|yh|1975@yhc|沿河城|YHP|yanhecheng|yhc|1976@yhu|岩会|AEP|yanhui|yh|1977@yjh|羊臼河|YHM|yangjiuhe|yjh|1978@yji|永嘉|URH|yongjia|yj|1979@yji|阳江|WRQ|yangjiang|yj|1980@yji|余江|YHG|yujiang|yj|1981@yji|燕郊|AJP|yanjiao|yj|1982@yji|营街|YAM|yingjie|yj|1983@yji|盐津|AEW|yanjin|yj|1984@yji|姚家|YAT|yaojia|yj|1985@yjj|岳家井|YGJ|yuejiajing|yjj|1986@yjp|一间堡|YJT|yijianpu|yjp|1987@yjs|英吉沙|YIR|yingjisha|yjs|1988@yjs|云居寺|AFP|yunjusi|yjs|1989@yjz|燕家庄|AZK|yanjiazhuang|yjz|1990@yka|永康|RFH|yongkang|yk|1991@ykd|营口东|YGT|yingkoudong|ykd|1992@yla|银浪|YJX|yinlang|yl|1993@yla|永郎|YLW|yonglang|yl|1994@ylb|宜良北|YSM|yiliangbei|ylb|1995@yld|永乐店|YDY|yongledian|yld|1996@ylh|伊拉哈|YLX|yilaha|ylh|1997@yli|杨陵|YSY|yangling|yl|1998@yli|伊林|YLB|yilin|yl|1999@yli|彝良|ALW|yiliang|yl|2000@yli|杨林|YLM|yanglin|yl|2001@ylp|余粮堡|YLD|yuliangpu|ylp|2002@ylq|杨柳青|YQP|yangliuqing|ylq|2003@ylt|月亮田|YUM|yueliangtian|ylt|2004@yma|义马|YMF|yima|ym|2005@ymb|阳明堡|YVV|yangmingbu|ymb|2006@yme|玉门|YXJ|yumen|ym|2007@yme|云梦|YMN|yunmeng|ym|2008@ymo|元谋|YMM|yuanmou|ym|2009@yms|一面山|YST|yimianshan|yms|2010@yna|沂南|YNK|yinan|yn|2011@yna|宜耐|YVM|yinai|yn|2012@ynd|伊宁东|YNR|yiningdong|ynd|2013@yps|营盘水|YZJ|yingpanshui|yps|2014@ypu|羊堡|ABM|yangpu|yp|2015@yqb|阳泉北|YPP|yangquanbei|yqb|2016@yqi|乐清|UPH|yueqing|yq|2017@yqi|焉耆|YSR|yanqi|yq|2018@yqi|源迁|AQK|yuanqian|yq|2019@yqt|姚千户屯|YQT|yaoqianhutun|yqht|2020@yqu|阳曲|YQV|yangqu|yq|2021@ysg|榆树沟|YGP|yushugou|ysg|2022@ysh|月山|YBF|yueshan|ys|2023@ysh|偃师|YSF|yanshi|ys|2024@ysh|颍上|YVH|yingshang|ys|2025@ysh|沂水|YUK|yishui|ys|2026@ysh|榆社|YSV|yushe|ys|2027@ysh|玉石|YSJ|yushi|ys|2028@ysh|玉舍|AUM|yushe|ys|2029@ysh|窑上|ASP|yaoshang|ys|2030@ysh|元氏|YSP|yuanshi|ys|2031@ysl|杨树岭|YAD|yangshuling|ysl|2032@ysp|野三坡|AIP|yesanpo|ysp|2033@yst|榆树屯|YSX|yushutun|yst|2034@yst|榆树台|YUT|yushutai|yst|2035@ysz|鹰手营子|YIP|yingshouyingzi|ysyz|2036@yta|源潭|YTQ|yuantan|yt|2037@ytp|牙屯堡|YTZ|yatunpu|ytp|2038@yts|烟筒山|YSL|yantongshan|yts|2039@ytt|烟筒屯|YUX|yantongtun|ytt|2040@yws|羊尾哨|YWM|yangweishao|yws|2041@yxi|越西|YHW|yuexi|yx|2042@yxi|阳西|WMQ|yangxi|yx|2043@yxi|永修|ACG|yongxiu|yx|2044@yxi|攸县|YOG|youxian|yx|2045@yxx|玉溪西|YXM|yuxixi|yxx|2046@yya|弋阳|YIG|yiyang|yy|2047@yya|余姚|YYH|yuyao|yy|2048@yya|酉阳|AFW|youyang|yy|2049@yyd|岳阳东|YIQ|yueyangdong|yyd|2050@yyi|阳邑|ARP|yangyi|yy|2051@yyu|鸭园|YYL|yayuan|yy|2052@yyz|鸳鸯镇|YYJ|yuanyangzhen|yyz|2053@yzb|燕子砭|YZY|yanzibian|yzb|2054@yzh|宜州|YSZ|yizhou|yz|2055@yzh|仪征|UZH|yizheng|yz|2056@yzh|兖州|YZK|yanzhou|yz|2057@yzi|迤资|YQM|yizi|yz|2058@yzw|羊者窝|AEM|yangzhewo|yzw|2059@yzz|杨杖子|YZD|yangzhangzi|yzz|2060@zan|镇安|ZEY|zhenan|za|2061@zan|治安|ZAD|zhian|za|2062@zba|招柏|ZBP|zhaobai|zb|2063@zbw|张百湾|ZUP|zhangbaiwan|zbw|2064@zcc|中川机场|ZJJ|zhongchuanjichang|zcjc|2065@zch|枝城|ZCN|zhicheng|zc|2066@zch|子长|ZHY|zichang|zc|2067@zch|诸城|ZQK|zhucheng|zc|2068@zch|邹城|ZIK|zoucheng|zc|2069@zch|赵城|ZCV|zhaocheng|zc|2070@zda|章党|ZHT|zhangdang|zd|2071@zdi|正定|ZDP|zhengding|zd|2072@zdo|肇东|ZDB|zhaodong|zd|2073@zfp|照福铺|ZFM|zhaofupu|zfp|2074@zgt|章古台|ZGD|zhanggutai|zgt|2075@zgu|赵光|ZGB|zhaoguang|zg|2076@zhe|中和|ZHX|zhonghe|zh|2077@zhm|中华门|VNH|zhonghuamen|zhm|2078@zjb|枝江北|ZIN|zhijiangbei|zjb|2079@zjc|钟家村|ZJY|zhongjiacun|zjc|2080@zjg|朱家沟|ZUB|zhujiagou|zjg|2081@zjg|紫荆关|ZYP|zijingguan|zjg|2082@zji|周家|ZOB|zhoujia|zj|2083@zji|诸暨|ZDH|zhuji|zj|2084@zjn|镇江南|ZEH|zhenjiangnan|zjn|2085@zjt|周家屯|ZOD|zhoujiatun|zjt|2086@zjw|褚家湾|CWJ|zhujiawan|zjw|2087@zjx|湛江西|ZWQ|zhanjiangxi|zjx|2088@zjy|朱家窑|ZUJ|zhujiayao|zjy|2089@zjz|曾家坪子|ZBW|zengjiapingzi|zjpz|2090@zla|镇赉|ZLT|zhenlai|zl|2091@zla|张兰|ZLV|zhanglan|zl|2092@zli|枣林|ZIV|zaolin|zl|2093@zlt|扎鲁特|ZLD|zhalute|zlt|2094@zlx|扎赉诺尔西|ZXX|zhalainuoerxi|zlnex|2095@zmt|樟木头|ZOQ|zhangmutou|zmt|2096@zmu|中牟|ZGF|zhongmu|zm|2097@znd|中宁东|ZDJ|zhongningdong|znd|2098@zni|中宁|VNJ|zhongning|zn|2099@znn|中宁南|ZNJ|zhongningnan|znn|2100@zpi|镇平|ZPF|zhenping|zp|2101@zpi|漳平|ZPS|zhangping|zp|2102@zpu|泽普|ZPR|zepu|zp|2103@zqi|枣强|ZVP|zaoqiang|zq|2104@zqi|张桥|ZQY|zhangqiao|zq|2105@zqi|章丘|ZTK|zhangqiu|zq|2106@zrh|朱日和|ZRC|zhurihe|zrh|2107@zrl|泽润里|ZLM|zerunli|zrl|2108@zsb|中山北|ZGQ|zhongshanbei|zsb|2109@zsd|樟树东|ZOG|zhangshudong|zsd|2110@zsh|柞水|ZSY|zhashui|zs|2111@zsh|中山|ZSQ|zhongshan|zs|2112@zsh|樟树|ZSG|zhangshu|zs|2113@zsh|珠斯花|ZHD|zhusihua|zsh|2114@zsh|钟山|ZSZ|zhongshan|zs|2115@zwo|珠窝|ZOP|zhuwo|zw|2116@zwt|张维屯|ZWB|zhangweitun|zwt|2117@zwu|彰武|ZWD|zhangwu|zw|2118@zxi|钟祥|ZTN|zhongxiang|zx|2119@zxi|资溪|ZXS|zixi|zx|2120@zxi|棕溪|ZOY|zongxi|zx|2121@zxi|镇西|ZVT|zhenxi|zx|2122@zxi|张辛|ZIP|zhangxin|zx|2123@zxq|正镶白旗|ZXC|zhengxiangbaiqi|zxbq|2124@zya|紫阳|ZVY|ziyang|zy|2125@zya|枣阳|ZYN|zaoyang|zy|2126@zyb|竹园坝|ZAW|zhuyuanba|zyb|2127@zye|张掖|ZYJ|zhangye|zy|2128@zyu|镇远|ZUW|zhenyuan|zy|2129@zzd|漳州东|GOS|zhangzhoudong|zzd|2130@zzh|漳州|ZUS|zhangzhou|zz|2131@zzh|子洲|ZZY|zizhou|zz|2132@zzh|涿州|ZXP|zhuozhou|zz|2133@zzh|壮志|ZUX|zhuangzhi|zz|2134@zzh|中寨|ZZM|zhongzhai|zz|2135@zzi|咋子|ZAL|zhazi|zz|2136@zzs|卓资山|ZZC|zhuozishan|zzs|2137@zzx|株洲西|ZAQ|zhuzhouxi|zzx|2138@zzx|郑州西|XPF|zhengzhouxi|zzx|2139@abq|阿巴嘎旗|AQC|abagaqi|abgq|2140@acb|阿城北|ABB|achengbei|acb|2141@aeb|阿尔山北|ARX|aershanbei|aesb|2142@ajd|安江东|ADA|anjiangdong|ajd|2143@aji|安吉|AJU|anji|aj|2144@alt|阿勒泰|AUR|aletai|alt|2145@alx|安陆西|AXN|anluxi|alx|2146@are|安仁|ARG|anren|ar|2147@asx|安顺西|ASE|anshunxi|asx|2148@atx|安图西|AXL|antuxi|atx|2149@atx|安亭西|AXU|antingxi|atx|2150@ayd|安阳东|ADF|anyangdong|ayd|2151@bba|博白|BBZ|bobai|bb|2152@bbu|八步|BBE|babu|bb|2153@bch|栟茶|FWH|bencha|bc|2154@bdc|八达岭长城|VLP|badalingchangcheng|bdlcc|2155@bdd|保定东|BMP|baodingdong|bdd|2156@bel|博尔塔拉|BER|boertala|betl|2157@bfs|八方山|FGQ|bafangshan|bfs|2158@bgo|白沟|FEP|baigou|bg|2159@bha|滨海|YKP|binhai|bh|2160@bhb|滨海北|FCP|binhaibei|bhb|2161@bhg|滨海港|BGU|binhaigang|bhg|2162@bhx|滨海西|FHP|binhaixi|bhx|2163@bji|毕节|BOE|bijie|bj|2164@bjn|宝鸡南|BBY|baojinan|bjn|2165@bjx|北京大兴|IPP|beijingdaxing|bjdx|2166@bjz|北井子|BRT|beijingzi|bjz|2167@blz|八里甸子|BLT|balidianzi|bldz|2168@bmj|白马井|BFQ|baimajing|bmj|2169@bpi|北票|BPT|beipiao|bp|2170@bqi|宝清|BUB|baoqing|bq|2171@bsh|璧山|FZW|bishan|bs|2172@bsp|白沙铺|BSN|baishapu|bsp|2173@bsx|白水县|BGY|baishuixian|bsx|2174@bta|板塘|NGQ|bantang|bt|2175@bwd|白文东|BCV|baiwendong|bwd|2176@bxb|宾西北|BBB|binxibei|bxb|2177@bxc|本溪新城|BVT|benxixincheng|bxxc|2178@bxj|步行街|BWW|buxingjie|bxj|2179@bya|宾阳|UKZ|binyang|by|2180@byb|白云北|BVE|baiyunbei|byb|2181@byd|白洋淀|FWP|baiyangdian|byd|2182@byi|百宜|FHW|baiyi|by|2183@byn|白音华南|BOD|baiyinhuanan|byhn|2184@bzd|巴中东|BDE|bazhongdong|bzd|2185@bzh|滨州|BIK|binzhou|bz|2186@bzh|彬州|BXY|binzhou|bz|2187@bzh|宾州|BZB|binzhou|bz|2188@bzn|亳州南|BNU|bozhounan|bzn|2189@bzx|霸州西|FOP|bazhouxi|bzx|2190@can|长安|CAA|changan|ca|2191@cax|长安西|CXA|changanxi|cax|2192@cch|澄城|CUY|chengcheng|cc|2193@cdb|承德县北|IYP|chengdexianbei|cdxb|2194@cdd|成  都东|WEI|chengdudong|cdd|2195@cdn|承德南|IVP|chengdenan|cdn|2196@cfd|曹妃甸东|POP|caofeidiandong|cfdd|2197@cfg|曹妃甸港|PGP|caofeidiangang|cfdg|2198@cgb|长葛北|CGF|changgebei|cgb|2199@cgb|城固北|CBY|chenggubei|cgb|2200@cgh|查干湖|VAT|chaganhu|cgh|2201@chd|巢湖东|GUH|chaohudong|chd|2202@cji|从江|KNW|congjiang|cj|2203@cjy|蔡家崖|EBV|caijiaya|cjy|2204@cka|茶卡|CVO|chaka|ck|2205@clh|长临河|FVH|changlinhe|clh|2206@cli|长流|CLA|changliu|cl|2207@cln|茶陵南|CNG|chalingnan|cln|2208@cni|长宁|CNE|changning|cn|2209@cpd|常平东|FQQ|changpingdong|cpd|2210@cpn|常平南|FPQ|changpingnan|cpn|2211@cqi|长箐|CQE|changqing|cq|2212@cqq|长庆桥|CQJ|changqingqiao|cqq|2213@cqx|重  庆西|WWI|chongqingxi|cqx|2214@csb|长寿北|COW|changshoubei|csb|2215@csh|长寿湖|CSE|changshouhu|csh|2216@csh|常熟|CAU|changshu|cs|2217@csh|潮汕|CBQ|chaoshan|cs|2218@csh|常山|CSU|changshan|cs|2219@csx|长沙西|RXQ|changshaxi|csx|2220@cti|朝天|CTE|chaotian|ct|2221@ctn|长汀南|CNS|changtingnan|ctn|2222@cwu|长武|CWY|changwu|cw|2223@cxi|长兴|CBH|changxing|cx|2224@cxi|苍溪|CXE|cangxi|cx|2225@cxi|楚雄|CUM|chuxiong|cx|2226@cxi|城西|CIA|chengxi|cx|2227@cya|朝阳|VBT|chaoyang|cy|2228@cya|长阳|CYN|changyang|cy|2229@cya|潮阳|CNQ|chaoyang|cy|2230@cyh|朝阳湖|CYE|chaoyanghu|cyh|2231@czh|崇州|CZE|chongzhou|cz|2232@czt|城子坦|CWT|chengzitan|czt|2233@dad|东安东|DCZ|dongandong|dad|2234@dba|德保|RBZ|debao|db|2235@dch|都昌|DCG|duchang|dc|2236@dch|东岔|DCJ|dongcha|dc|2237@dcn|东城南|IYQ|dongchengnan|dcn|2238@ddh|东戴河|RDD|dongdaihe|ddh|2239@ddx|丹东西|RWT|dandongxi|ddx|2240@deh|东二道河|DRB|dongerdaohe|dedh|2241@dfa|大方|DFE|dafang|df|2242@dfe|大丰|KRQ|dafeng|df|2243@dfn|大方南|DNE|dafangnan|dfn|2244@dgb|东港北|RGT|donggangbei|dgb|2245@dgg|东莞港|DGA|dongguangang|dgg|2246@dgs|大孤山|RMT|dagushan|dgs|2247@dgu|东莞|RTQ|dongguan|dg|2248@dgx|东莞西|WGQ|dongguanxi|dgx|2249@dhb|东花园北|QBP|donghuayuanbei|dhyb|2250@dhd|鼎湖东|UWQ|dinghudong|dhd|2251@dhs|鼎湖山|NVQ|dinghushan|dhs|2252@dji|道滘|RRQ|daojiao|dj|2253@dji|垫江|DJE|dianjiang|dj|2254@dji|洞井|FWQ|dongjing|dj|2255@djk|丹江口|DON|danjiangkou|djk|2256@djk|董家口|DTK|dongjiakou|djk|2257@dju|大苴|DIM|daju|dj|2258@dko|洞口|DKA|dongkou|dk|2259@dlh|达连河|DCB|dalianhe|dlh|2260@dli|大荔|DNY|dali|dl|2261@dlz|大朗镇|KOQ|dalangzhen|dlz|2262@dml|得莫利|DTB|demoli|dml|2263@dqg|大青沟|DSD|daqinggou|dqg|2264@dqi|德清|DRH|deqing|dq|2265@dsd|东胜东|RSC|dongshengdong|dsd|2266@dsn|砀山南|PRH|dangshannan|dsn|2267@dsn|大石头南|DAL|dashitounan|dstn|2268@dtd|当涂东|OWH|dangtudong|dtd|2269@dtn|大同南|DMV|datongnan|dtn|2270@dtx|大通西|DTO|datongxi|dtx|2271@dwa|大旺|WWQ|dawang|dw|2272@dxb|定西北|DNJ|dingxibei|dxb|2273@dxc|大兴机场|IWP|daxingjichang|dxjc|2274@dxd|德兴东|DDG|dexingdong|dxd|2275@dxi|德兴|DWG|dexing|dx|2276@dxs|丹霞山|IRQ|danxiashan|dxs|2277@dya|大阳|RET|dayang|dy|2278@dyb|大冶北|DBN|dayebei|dyb|2279@dyd|都匀东|KJW|duyundong|dyd|2280@dyi|大邑|DEE|dayi|dy|2281@dyn|东营南|DOK|dongyingnan|dyn|2282@dyu|大余|DYG|dayu|dy|2283@dzd|邓州东|DDF|dengzhoudong|dzd|2284@dzd|定州东|DOP|dingzhoudong|dzd|2285@dzh|端州|WZQ|duanzhou|dz|2286@dzn|大足南|FQW|dazunan|dzn|2287@emi|额敏|EMR|emin|em|2288@ems|峨眉山|IXW|emeishan|ems|2289@epg|阿房宫|EGY|epanggong|epg|2290@ezd|鄂州东|EFN|ezhoudong|ezd|2291@fcb|防城港北|FBZ|fangchenggangbei|fcgb|2292@fcd|丰城东|FIG|fengchengdong|fcd|2293@fcd|凤城东|FDT|fengchengdong|fcd|2294@fch|富川|FDZ|fuchuan|fc|2295@fch|方城|FNF|fangcheng|fc|2296@fcx|繁昌西|PUH|fanchangxi|fcx|2297");
		buf.append("@fdu|丰都|FUW|fengdu|fd|2298@fgn|扶沟南|FGF|fugounan|fgn|2299@fhx|福海西|FHA|fuhaixi|fhx|2300@flb|涪陵北|FEW|fulingbei|flb|2301@fli|枫林|FLN|fenglin|fl|2302@fnd|阜宁东|FDU|funingdong|fnd|2303@fni|富宁|FNM|funing|fn|2304@fnn|阜宁南|FNU|funingnan|fnn|2305@fnn|阜宁南|FNU|funingnan|fnn|2306@fpi|佛坪|FUY|foping|fp|2307@fqi|法启|FQE|faqi|fq|2308@frn|芙蓉南|KCQ|furongnan|frn|2309@fsd|丰顺东|FDA|fengshundong|fsd|2310@fsh|复盛|FAW|fusheng|fs|2311@fso|抚松|FSL|fusong|fs|2312@fsx|佛山西|FOQ|foshanxi|fsx|2313@fsz|福山镇|FZQ|fushanzhen|fsz|2314@fti|福田|NZQ|futian|ft|2315@ftn|凤台南|FTU|fengtainan|ftn|2316@fxb|费县北|FBK|feixianbei|fxb|2317@fxi|阜新|FOT|fuxin|fx|2318@fya|富阳|FYU|fuyang|fy|2319@fyb|富源北|FBM|fuyuanbei|fyb|2320@fyu|抚远|FYB|fuyuan|fy|2321@fyx|阜阳西|FXU|fuyangxi|fyx|2322@fzd|抚州东|FDG|fuzhoudong|fzd|2323@fzh|抚州|FZG|fuzhou|fz|2324@fzh|方正|FNB|fangzheng|fz|2325@fzn|福州 南|FXS|fuzhounan|fzn|2326@gan|高安|GCG|gaoan|ga|2327@gan|广安南|VUW|guangannan|gan|2328@gan|贵安|GAE|guian|ga|2329@gbd|高碑店东|GMP|gaobeidiandong|gbdd|2330@gbk|古北口|GKP|gubeikou|gbk|2331@gcb|谷城北|GBN|guchengbei|gcb|2332@gcd|古城东|GUU|guchengdong|gcd|2333@gch|恭城|GCZ|gongcheng|gc|2334@gcn|藁城南|GUP|gaochengnan|gcn|2335@gdb|贵定北|FMW|guidingbei|gdb|2336@gdn|广德南|GNU|guangdenan|gdn|2337@gdn|葛店南|GNN|gediannan|gdn|2338@gdx|贵定县|KIW|guidingxian|gdx|2339@ghb|广汉北|GVW|guanghanbei|ghb|2340@ghu|高花|HGD|gaohua|gh|2341@gju|革居|GEM|geju|gj|2342@gle|高楞|GLB|gaoleng|gl|2343@gli|关岭|GLE|guanling|gl|2344@glx|桂林西|GEZ|guilinxi|glx|2345@gmb|高密北|GVK|gaomibei|gmb|2346@gmc|光明城|IMQ|guangmingcheng|gmc|2347@gna|灌南|GIU|guannan|gn|2348@gni|广宁|FBQ|guangning|gn|2349@gns|广宁寺|GQT|guangningsi|gns|2350@gnx|广南县|GXM|guangnanxian|gnx|2351@gpi|桂平|GAZ|guiping|gp|2352@gpi|广平|GPP|guangping|gp|2353@gpz|弓棚子|GPT|gongpengzi|gpz|2354@gsd|赶水东|GDE|ganshuidong|gsd|2355@gsh|光山|GUN|guangshan|gs|2356@gsh|谷山|FFQ|gushan|gs|2357@gsl|观沙岭|FKQ|guanshaling|gsl|2358@gtb|古田北|GBS|gutianbei|gtb|2359@gtb|广通北|GPM|guangtongbei|gtb|2360@gtn|高台南|GAJ|gaotainan|gtn|2361@gtz|古田会址|STS|gutianhuizhi|gthz|2362@gxb|赣县北|GIG|ganxianbei|gxb|2363@gyb|贵  阳北|WNI|guiyangbei|gyb|2364@gyb|贵阳北|KQW|guiyangbei|gyb|2365@gyc|观音机场|GCU|guanyinjichang|gyjc|2366@gyd|贵阳东|KEW|guiyangdong|gyd|2367@gyu|灌云|GOU|guanyun|gy|2368@gyu|赣榆|GYU|ganyu|gy|2369@gyx|高邑西|GNP|gaoyixi|gyx|2370@gzx|赣州西|GOG|ganzhouxi|gzx|2371@had|淮安东|HAU|huaiandong|had|2372@had|淮安东|HAU|huaiandong|had|2373@han|怀安|QAP|huaian|ha|2374@han|惠安|HNS|huian|ha|2375@hbb|淮北北|PLH|huaibeibei|hbb|2376@hbd|鹤壁东|HFF|hebidong|hbd|2377@hbs|花博山|KBT|huaboshan|hbs|2378@hcg|寒葱沟|HKB|hanconggou|hcg|2379@hch|霍城|SER|huocheng|hc|2380@hch|珲春|HUL|hunchun|hc|2381@hdc|河东机场|HFJ|hedongjichang|hdjc|2382@hdd|横道河子东|KUX|hengdaohezidong|hdhzd|2383@hdd|邯郸东|HPP|handandong|hdd|2384@hdo|海东|LVO|haidong|hd|2385@hdo|惠东|KDQ|huidong|hd|2386@hdp|哈达铺|HDJ|hadapu|hdp|2387@hdx|洪洞西|HTV|hongtongxi|hdx|2388@hdx|海东西|HDO|haidongxi|hdx|2389@heb|哈尔滨北|HTB|haerbinbei|hebb|2390@hfc|合肥北城|COH|hefeibeicheng|hfbc|2391@hfn|合肥南|ENH|hefeinan|hfn|2392@hga|黄冈|KGN|huanggang|hg|2393@hgd|黄冈东|KAN|huanggangdong|hgd|2394@hgd|横沟桥东|HNN|henggouqiaodong|hgqd|2395@hgx|黄冈西|KXN|huanggangxi|hgx|2396@hhe|洪河|HPB|honghe|hh|2397@hhn|怀化南|KAQ|huaihuanan|hhn|2398@hhq|黄河景区|HCF|huanghejingqu|hhjq|2399@hhu|惠环|KHQ|huihuan|hh|2400@hhu|花湖|KHN|huahu|hh|2401@hhu|后湖|IHN|houhu|hh|2402@hji|厚街|HJA|houjie|hj|2403@hji|怀集|FAQ|huaiji|hj|2404@hkb|河口北|HBM|hekoubei|hkb|2405@hkl|宏克力|OKB|hongkeli|hkl|2406@hla|怀来|VQP|huailai|hl|2407@hlb|海林北|KBX|hailinbei|hlb|2408@hli|黄流|KLQ|huangliu|hl|2409@hln|黄陵南|VLY|huanglingnan|hln|2410@hmb|虎门北|HBA|humenbei|hmb|2411@hmd|虎门东|HDA|humendong|hmd|2412@hme|鲘门|KMQ|houmen|hm|2413@hme|海门|HMU|haimen|hm|2414@hme|洪梅|HMA|hongmei|hm|2415@hme|虎门|IUQ|humen|hm|2416@hmx|侯马西|HPV|houmaxi|hmx|2417@hna|衡南|HNG|hengnan|hn|2418@hnd|淮南东|HOH|huainandong|hnd|2419@hnn|淮南南|HNU|huainannan|hnn|2420@hpu|合浦|HVZ|hepu|hp|2421@hqb|横琴北|HOA|hengqinbei|hqb|2422@hqi|霍邱|FBH|huoqiu|hq|2423@hqi|横琴|HQA|hengqin|hq|2424@hrd|怀仁东|HFV|huairendong|hrd|2425@hrd|华容东|HPN|huarongdong|hrd|2426@hrn|华容南|KRN|huarongnan|hrn|2427@hsb|红寺堡北|HEJ|hongsibaobei|hsbb|2428@hsb|黑山北|HQT|heishanbei|hsb|2429@hsb|衡水北|IHP|hengshuibei|hsb|2430@hsb|黄山北|NYH|huangshanbei|hsb|2431@hsb|黄石北|KSN|huangshibei|hsb|2432@hsd|贺胜桥东|HLN|heshengqiaodong|hsqd|2433@hsh|和硕|VUR|heshuo|hs|2434@hsn|含山南|HSU|hanshannan|hsn|2435@hsn|含山南|HSU|hanshannan|hsn|2436@hsn|花山南|KNN|huashannan|hsn|2437@hss|黑山寺|HVP|heishansi|hss|2438@hta|荷塘|KXQ|hetang|ht|2439@htb|黄桶北|HBE|huangtongbei|htb|2440@htd|黄土店|HKP|huangtudian|htd|2441@htg|花土沟|HTO|huatugou|htg|2442@hyb|海阳北|HEK|haiyangbei|hyb|2443@hyb|合阳北|HTY|heyangbei|hyb|2444@hyi|槐荫|IYN|huaiyin|hy|2445@hyi|鄠邑|KXY|huyi|hyi|2446@hyk|花园口|HYT|huayuankou|hyk|2447@hyn|淮阳南|HVF|huaiyangnan|hyn|2448@hzd|霍州东|HWV|huozhoudong|hzd|2449@hzn|惠州南|KNQ|huizhounan|hzn|2450@jan|建安|JUL|jianan|ja|2451@jax|吉安西|JIG|jianxi|jax|2452@jch|泾川|JAJ|jingchuan|jc|2453@jch|碱厂|JUT|jianchang|jc|2454@jdb|景德镇北|JDG|jingdezhenbei|jdzb|2455@jde|旌德|NSH|jingde|jd|2456@jde|建德|JDU|jiande|jd|2457@jfe|尖峰|PFQ|jianfeng|jf|2458@jha|近海|JHD|jinhai|jh|2459@jhx|蛟河西|JOL|jiaohexi|jhx|2460@jlb|军粮城北|JMP|junliangchengbei|jlcb|2461@jle|将乐|JLS|jiangle|jl|2462@jlh|贾鲁河|JLF|jialuhe|jlh|2463@jls|九郎山|KJQ|jiulangshan|jls|2464@jmb|即墨北|JVK|jimobei|jmb|2465@jmg|剑门关|JME|jianmenguan|jmg|2466@jmx|佳木斯西|JUB|jiamusixi|jmsx|2467@jnb|莒南北|VNK|junanbei|jnb|2468@jnb|建宁县北|JCS|jianningxianbei|jnxb|2469@jnd|济南东|MDK|jinandong|jnd|2470@jni|江宁|JJH|jiangning|jn|2471@jnx|江宁西|OKH|jiangningxi|jnx|2472@jox|建瓯西|JUS|jianouxi|jox|2473@jpi|建平|JAD|jianping|jp|2474@jqi|建桥|JQA|jianqiao|jq|2475@jqn|酒泉南|JNJ|jiuquannan|jqn|2476@jrx|句容西|JWH|jurongxi|jrx|2477@jsh|建水|JSM|jianshui|js|2478@jsh|尖山|JPQ|jianshan|js|2479@jsn|界首南|JKU|jieshounan|jsn|2480@jss|界首市|JUN|jieshoushi|jss|2481@jsx|吉水西|JSG|jishuixi|jsx|2482@jxb|绩溪北|NRH|jixibei|jxb|2483@jxd|介休东|JDV|jiexiudong|jxd|2484@jxi|靖西|JMZ|jingxi|jx|2485@jxi|泾县|LOH|jingxian|jx|2486@jxi|郏县|JXF|jiaxian|jx|2487@jxn|进贤南|JXG|jinxiannan|jxn|2488@jya|揭阳|JYA|jieyang|jy|2489@jyb|江油北|JBE|jiangyoubei|jyb|2490@jyc|揭阳机场|JUA|jieyangjichang|jyjc|2491@jyn|简阳南|JOW|jianyangnan|jyn|2492@jyn|嘉峪关南|JBJ|jiayuguannan|jygn|2493@jyt|金银潭|JTN|jinyintan|jyt|2494@jyu|靖宇|JYL|jingyu|jy|2495@jyw|金月湾|PYQ|jinyuewan|jyw|2496@jyx|缙云西|PYH|jinyunxi|jyx|2497@jzh|景州|JEP|jingzhou|jz|2498@jzh|晋中|JZV|jinzhong|jz|2499@kfb|开封北|KBF|kaifengbei|kfb|2500@kfs|开福寺|FLQ|kaifusi|kfs|2501@khu|开化|KHU|kaihua|kh|2502@kln|凯里南|QKW|kailinan|kln|2503@klu|库伦|KLD|kulun|kl|2504@kmn|昆明南|KOM|kunmingnan|kmn|2505@kta|葵潭|KTQ|kuitan|kt|2506@kya|开阳|KVW|kaiyang|ky|2507@kyu|昆玉|ESR|kunyu|ky|2508@kzu|喀左|KZT|kazuo|kz|2509@lad|隆安东|IDZ|longandong|lad|2510@lba|冷坝|LBE|lengba|lb|2511@lbb|来宾北|UCZ|laibinbei|lbb|2512@lbi|灵璧|GMH|lingbi|lb|2513@lbu|寮步|LTQ|liaobu|lb|2514@lby|绿博园|LCF|lvboyuan|lby|2515@lcb|隆昌北|NWW|longchangbei|lcb|2516@lcd|乐昌东|ILQ|lechangdong|lcd|2517@lch|临城|UUP|lincheng|lc|2518@lch|罗城|VCZ|luocheng|lc|2519@lch|陵城|LGK|lingcheng|lc|2520@lcz|老城镇|ACQ|laochengzhen|lcz|2521@ldb|龙洞堡|FVW|longdongbao|ldb|2522@ldn|娄底南|UOQ|loudinan|ldn|2523@ldo|乐东|UQQ|ledong|ld|2524@ldy|离堆公园|INW|liduigongyuan|ldgy|2525@lfa|娄烦|USV|loufan|lf|2526@lfe|来凤|LFA|laifeng|lf|2527@lfe|陆丰|LLQ|lufeng|lf|2528@lfe|龙丰|KFQ|longfeng|lf|2529@lfn|禄丰南|LQM|lufengnan|lfn|2530@lfx|临汾西|LXV|linfenxi|lfx|2531@lgn|临高南|KGQ|lingaonan|lgn|2532@lgu|麓谷|BNQ|lugu|lg|2533@lhe|滦河|UDP|luanhe|lh|2534@lhn|珞璜南|LNE|luohuangnan|lhn|2535@lhu|隆回|LHA|longhui|lh|2536@lhx|漯河西|LBN|luohexi|lhx|2537@ljd|罗江东|IKW|luojiangdong|ljd|2538@lji|柳江|UQZ|liujiang|lj|2539@ljn|利津南|LNK|lijinnan|ljn|2540@ljz|厉家寨|UPK|lijiazhai|ljz|2541@lkn|兰考南|LUF|lankaonan|lkn|2542@lks|龙口市|UKK|longkoushi|lks|2543@llb|兰陵北|COK|lanlingbei|llb|2544@llb|龙里北|KFW|longlibei|llb|2545@llb|沥林北|KBQ|lilinbei|llb|2546@lld|醴陵东|UKQ|lilingdong|lld|2547@lmi|芦庙|LMU|lumiao|lm|2548@lna|陇南|INJ|longnan|ln|2549@lpd|六盘水东|LDE|liupanshuidong|lpsd|2550@lpn|梁平南|LPE|liangpingnan|lpn|2551@lqi|龙桥|LQU|longqiao|lq|2552@lqu|礼泉|LGY|liquan|lq|2553@lqu|临泉|LOU|linquan|lq|2554@lsb|龙山北|LBA|longshanbei|lsb|2555@lsd|灵石东|UDV|lingshidong|lsd|2556@lsh|涟水|LIU|lianshui|ls|2557@lsh|乐山|IVW|leshan|ls|2558@lsh|龙市|LAG|longshi|ls|2559@lsh|溧水|LDH|lishui|ls|2560@lsn|娄山关南|LSE|loushanguannan|lsgn|2561@lsx|岚山西|UWK|lanshanxi|lsx|2562@lwb|灵武北|UWJ|lingwubei|lwb|2563@lwj|洛湾三江|KRW|luowansanjiang|lwsj|2564@lxb|莱西北|LBK|laixibei|lxb|2565@lxi|岚县|UXV|lanxian|lx|2566@lxn|郎溪南|LXU|langxinan|lxn|2567@lya|溧阳|LEH|liyang|ly|2568@lyb|临沂北|UMK|linyibei|lyb|2569@lyb|临  沂北|III|linyibei|lyb|2570@lyi|临邑|LUK|linyi|ly|2571@lyn|柳园南|LNR|liuyuannan|lyn|2572@lzb|鹿寨北|LSZ|luzhaibei|lzb|2573@lzb|临淄北|UEK|linzibei|lzb|2574@lzh|阆中|LZE|langzhong|lz|2575@lzn|临泽南|LDJ|linzenan|lzn|2576@lzn|六枝南|LOE|liuzhinan|lzn|2577@mad|马鞍山东|OMH|maanshandong|masd|2578@mch|毛陈|MHN|maochen|mc|2579@mex|帽儿山西|MUB|mershanxi|mesx|2580@mgd|明港东|MDN|minggangdong|mgd|2581@mhn|民和南|MNO|minhenan|mhn|2582@mji|闵集|MJN|minji|mj|2583@mla|马兰|MLR|malan|ml|2584@mle|民乐|MBJ|minle|ml|2585@mle|弥勒|MLM|mile|ml|2586@mns|玛纳斯|MSR|manasi|mns|2587@mpi|牟平|MBK|muping|mp|2588@mqb|闽清北|MBS|minqingbei|mqb|2589@mqb|民权北|MIF|minquanbei|mqb|2590@msd|眉山东|IUW|meishandong|msd|2591@msh|蒙山|MOK|mengshan|ms|2592@msh|名山|MSE|mingshan|ms|2593@msh|庙山|MSN|miaoshan|ms|2594@mxi|岷县|MXJ|minxian|mx|2595@myu|门源|MYO|menyuan|my|2596@myu|暮云|KIQ|muyun|my|2597@mzb|蒙自北|MBM|mengzibei|mzb|2598@mzh|孟庄|MZF|mengzhuang|mz|2599@mzi|蒙自|MZM|mengzi|mz|2600@mzx|梅州西|MXA|meizhouxi|mzx|2601@nbu|南部|NBE|nanbu|nb|2602@nca|南曹|NEF|nancao|nc|2603@ncb|南充北|NCE|nanchongbei|ncb|2604@nch|牛车河|NHA|niuchehe|nch|2605@nch|南城|NDG|nancheng|nc|2606@nch|宁城|NCD|ningcheng|nc|2607@nch|南 昌|NOG|nanchang|nc|2608@ncx|南昌西|NXG|nanchangxi|ncx|2609@ndn|宁东南|NDJ|ningdongnan|ndn|2610@ndo|宁东|NOJ|ningdong|nd|2611@nfb|南芬北|NUT|nanfenbei|nfb|2612@nfe|南丰|NFG|nanfeng|nf|2613@nhd|南湖东|NDN|nanhudong|nhd|2614@nhl|牛河梁|LKT|niuheliang|nhl|2615@nhu|南华|NAM|nanhua|nh|2616@njb|内江北|NKW|neijiangbei|njb|2617@nji|南江|FIW|nanjiang|nj|2618@njk|南江口|NDQ|nanjiangkou|njk|2619@nlg|奈林皋|NGT|nailingao|nlg|2620@nli|南陵|LLH|nanling|nl|2621@nls|牛栏山|NLP|niulanshan|nls|2622@nmu|尼木|NMO|nimu|nm|2623@nnd|南宁东|NFZ|nanningdong|nnd|2624@nnx|南宁西|NXZ|nanningxi|nnx|2625@npb|南堡北|TLP|nanpubei|npb|2626@nps|南平市|NOS|nanpingshi|nps|2627@nqn|宁强南|NOY|ningqiangnan|nqn|2628@ntx|南通西|NXU|nantongxi|ntx|2629@nxi|泥溪|NIE|nixi|nxi|2630@nxi|南雄|NCQ|nanxiong|nx|2631@nyd|南阳东|NOF|nanyangdong|nyd|2632@nyo|纳雍|NYE|nayong|ny|2633@nyz|南阳寨|NYF|nanyangzhai|nyz|2634@pan|普安|PAN|puan|pa|2635@pax|普安县|PUE|puanxian|pax|2636@pbi|屏边|PBM|pingbian|pb|2637@pbn|平坝南|PBE|pingbanan|pbn|2638@pch|平昌|PCE|pingchang|pc|2639@pdi|普定|PGW|puding|pd|2640@pdx|平顶山西|PDF|pingdingshanxi|pdsx|2641@pdx|平度西|PAK|pingduxi|pdx|2642@pji|蒲江|PJE|pujiang|pj|2643@pko|皮口|PUT|pikou|pk|2644@plc|盘龙城|PNN|panlongcheng|plc|2645@pls|蓬莱市|POK|penglaishi|pls|2646@pni|普宁|PEQ|puning|pn|2647@pnn|平南南|PAZ|pingnannan|pnn|2648@pqb|平泉北|PBP|pingquanbei|pqb|2649@psb|彭山北|PPW|pengshanbei|psb|2650@psh|屏山|PSE|pingshan|psh|2651@psh|盘山|PUD|panshan|ps|2652@psh|坪上|PSK|pingshang|ps|2653@pxb|萍乡北|PBG|pingxiangbei|pxb|2654@pya|濮阳|PYF|puyang|py|2655@pya|鄱阳|PYG|poyang|py|2656@pyc|平遥古城|PDV|pingyaogucheng|pygc|2657@pyd|平原东|PUK|pingyuandong|pyd|2658@pzh|普者黑|PZM|puzhehei|pzh|2659@pzh|盘州|PAE|panzhou|pz|2660@pzh|平庄|PAD|pingzhuang|pz|2661@pzh|彭州|PMW|pengzhou|pz|2662@pzn|攀枝花南|PNE|panzhihuanan|pzhn|2663@pzn|彭州南|PKW|pengzhounan|pzn|2664@qan|秦安|QGJ|qinan|qa|2665@qbd|青白江东|QFW|qingbaijiangdong|qbjd|2666@qch|青川|QCE|qingchuan|qc|2667@qdb|青岛北|QHK|qingdaobei|qdb|2668@qdb|青  岛北|KAI|qingdaobei|qdb|2669@qdh|千岛湖|QDU|qiandaohu|qdh|2670@qdo|祁东|QMQ|qidong|qd|2671@qdo|启东|QOU|qidong|qd|2672@qdu|青堆|QET|qingdui|qd|2673@qdx|青岛西|QUK|qingdaoxi|qdx|2674@qfe|前锋|QFB|qianfeng|qf|2675@qhb|清河门北|QBD|qinghemenbei|qhmb|2676@qhe|齐河|QIK|qihe|qh|2677@qjb|曲靖北|QBM|qujingbei|qjb|2678@qjd|綦江东|QDE|qijiangdong|qjd|2679@qji|曲江|QIM|qujiang|qj|2680@qla|邛崃|QLE|qionglai|ql|2681@qli|青莲|QEW|qinglian|ql|2682@qqn|齐齐哈尔南|QNB|qiqihaernan|qqhen|2683@qsb|清水北|QEJ|qingshuibei|qsb|2684@qsh|青神|QVW|qingshen|qs|2685@qsh|岐山|QAY|qishan|qs|2686@qsh|庆盛|QSQ|qingsheng|qs|2687@qsx|清水县|QIJ|qingshuixian|qsx|2688@qsx|曲水县|QSO|qushuixian|qsx|2689@qwe|犍为|JWE|qianwei|qwe|2690@qxd|祁县东|QGV|qixiandong|qxd|2691@qxi|黔西|QXE|qianxi|qx|2692@qxi|乾县|QBY|qianxian|qx|2693@qxn|旗下营南|QNC|qixiayingnan|qxyn|2694@qya|祁阳|QWQ|qiyang|qy|2695@qzb|青州市北|QOK|qingzhoushibei|qzsb|2696@qzd|乔庄东|QEP|qiaozhuangdong|qzd|2697@qzn|全州南|QNZ|quanzhounan|qzn|2698@qzw|棋子湾|QZQ|qiziwan|qzw|2699@qzx|清镇西|QUE|qingzhenxi|qzx|2700@rbu|仁布|RUO|renbu|rb|2701@rcb|荣昌北|RQW|rongchangbei|rcb|2702@rch|荣成|RCK|rongcheng|rc|2703@rcx|瑞昌西|RXG|ruichangxi|rcx|2704@rdo|如东|RIH|rudong|rd|2705@rji|榕江|RVW|rongjiang|rj|2706@rkz|日喀则|RKO|rikaze|rkz|2707@rpi|饶平|RVQ|raoping|rp|2708@rzx|日照西|KZK|rizhaoxi|rzx|2709@scl|宋城路|SFF|songchenglu|scl|2710@sdh|三道湖|SDL|sandaohu|sdh|2711@sdo|邵东|FIQ|shaodong|sd|2712@sdx|三都县|KKW|sanduxian|sdx|2713@sfa|胜芳|SUP|shengfang|sf|2714@sfb|双峰北|NFQ|shuangfengbei|sfb|2715@she|商河|SOK|shanghe|sh|2716@sho|泗洪|GQH|sihong|sh|2717@shs|双河市|OHR|shuangheshi|shs|2718@shu|四会|AHQ|sihui|sh|2719@sjb|畲江北|SOA|shejiangbei|sjb|2720@sjd|石家庄东|SXP|shijiazhuangdong|sjzd|2721@sjn|三江南|SWZ|sanjiangnan|sjn|2722@sjx|沙井西|SJA|shajingxi|sjx|2723@sjz|三井子|OJT|sanjingzi|sjz|2724@sks|四棵树|SIR|sikeshu|sks|2725@slc|双流机场|IPW|shuangliujichang|sljc|2726@slh|双龙湖|OHB|shuanglonghu|slh|2727@slx|石林西|SYM|shilinxi|slx|2728@slx|双流西|IQW|shuangliuxi|slx|2729@slz|胜利镇|OLB|shenglizhen|slz|2730@smb|三明北|SHS|sanmingbei|smb|2731@smi|三明|SVS|sanming|sm|2732@smi|嵩明|SVM|songming|sm|2733@sml|树木岭|FMQ|shumuling|sml|2734@smu|神木|HMY|shenmu|sm|2735@sni|睢宁|SNU|suining|sn|2736@snq|苏尼特左旗|ONC|sunitezuoqi|sntzq|2737@spd|山坡东|SBN|shanpodong|spd|2738@sqb|沈丘北|SKF|shenqiubei|sqb|2739@sqd|商丘东|SIF|shangqiudong|sqd|2740@sqi|宿迁|SQU|suqian|sq|2741@sqi|沈丘|SQN|shenqiu|sq|2742@sqi|石桥|SQE|shiqiao|sq|2743@ssb|鄯善北|SMR|shanshanbei|ssb|2744@ssb|狮山北|NSQ|shishanbei|ssb|2745@ssb|三水北|ARQ|sanshuibei|ssb|2746@ssb|松山湖北|KUQ|songshanhubei|sshb|2747@ssh|狮山|KSQ|shishan|ss|2748@ssn|泗水南|ONK|sishuinan|ssn|2749@ssn|三水南|RNQ|sanshuinan|ssn|2750@ssn|韶山南|INQ|shaoshannan|ssn|2751@ssu|三穗|QHW|sansui|ss|2752@sti|石梯|STE|shiti|st|2753@swe|汕尾|OGQ|shanwei|sw|2754@sxb|歙县北|NPH|shexianbei|sxb|2755@sxb|绍兴北|SLH|shaoxingbei|sxb|2756@sxd|绍兴东|SSH|shaoxingdong|sxd|2757@sxi|寿县|SOU|shouxian|sx|2758@sxi|泗县|GPH|sixian|sx|2759@sxi|始兴|IPQ|shixing|sx|2760@sxi|随县|OVN|suixian|sx|2761@sya|泗阳|MPH|siyang|sy|2762@sya|双洋|SQS|shuangyang|sy|2763@sya|三阳|SYU|sanyang|sy|2764@sya|射阳|SAU|sheyang|sy|2765@sya|双阳|OYT|shuangyang|sy|2766@syb|邵阳北|OVQ|shaoyangbei|syb|2767@syb|松原北|OCT|songyuanbei|syb|2768@syd|十堰东|OUN|shiyandong|syd|2769@syi|山阴|SNV|shanyin|sy|2770@syx|邵阳西|SXA|shaoyangxi|syx|2771@syx|沈阳西|OOT|shenyangxi|syx|2772@szb|深圳机场北|SBA|shenzhenjichangbei|szjcb|2773@szb|深圳北|IOQ|shenzhenbei|szb|2774@szc|深圳机场|SCA|shenzhenjichang|szjc|2775@szh|神州|SRQ|shenzhou|sz|2776@szh|桑植|SZA|sangzhi|sz|2777@szm|十字门|SIA|shizimen|szm|2778@szn|尚志南|OZB|shangzhinan|szn|2779@szn|随州南|ONN|suizhounan|szn|2780@szs|石嘴山|QQJ|shizuishan|szs|2781@szs|深圳坪山|IFQ|shenzhenpingshan|szps|2782@szx|石柱县|OSW|shizhuxian|szx|2783@tan|台安南|TAD|taiannan|tan|2784@tca|太仓|TCU|taicang|tc|2785@tcb|桃村北|TOK|taocunbei|tcb|2786@tcg|铁厂沟|TJR|tiechanggou|tcg|2787@tch|塔城|TZR|tacheng|tc|2788@tcn|太仓南|TNU|taicangnan|tcn|2789@tcs|铁刹山|PST|tiechashan|tcs|2790@tdb|田东北|TBZ|tiandongbei|tdb|2791@tdd|土地堂东|TTN|tuditangdong|tdtd|2792@tgx|太谷西|TIV|taiguxi|tgx|2793@tha|吐哈|THR|tuha|th|2794@tha|通海|TAM|tonghai|th|2795@thb|太和北|JYN|taihebei|thb|2796@thc|天河机场|TJN|tianhejichang|thjc|2797@thd|太和东|TDU|taihedong|thd|2798@thj|天河街|TEN|tianhejie|thj|2799@thn|唐海南|IEP|tanghainan|thn|2800@thx|通化县|TXL|tonghuaxian|thx|2801@tji|同江|TJB|tongjiang|tj|2802@tkd|托克托东|TVC|tuoketuodong|tktd|2803@tlb|吐鲁番北|TAR|tulufanbei|tlfb|2804@tlb|铜陵北|KXH|tonglingbei|tlb|2805@tlu|桐庐|TLU|tonglu|tl|2806@tni|泰宁|TNS|taining|tn|2807@trn|铜仁南|TNW|tongrennan|trn|2808@tsn|天水南|TIJ|tianshuinan|tsn|2809@twe|通渭|TWJ|tongwei|tw|2810@txd|田心东|KQQ|tianxindong|txd|2811@txh|汤逊湖|THN|tangxunhu|txh|2812@txi|藤县|TAZ|tengxian|tx|2813@tyn|太原南|TNV|taiyuannan|tyn|2814@tyu|桃源|TYA|taoyuan|ty|2815@tyx|通远堡西|TST|tongyuanpuxi|typx|2816@tzb|桐梓北|TBE|tongzibei|tzb|2817@tzc|太子城|IZP|taizicheng|tzc|2818@tzd|桐梓东|TDE|tongzidong|tzd|2819@tzh|通州|TOP|tongzhou|tz|2820@wax|万安县|WAG|wananxian|wax|2821@wch|吴川|WAQ|wuchuan|wc|2822@wdd|文登东|WGK|wendengdong|wdd|2823@wdx|武当山西|WWN|wudangshanxi|wdsx|2824@wfb|潍坊北|WJK|weifangbei|wfb|2825@wfs|五府山|WFG|wufushan|wfs|2826@whb|威虎岭北|WBL|weihulingbei|whlb|2827@whb|威海北|WHK|weihaibei|whb|2828@whb|芜湖北|WBU|wuhubei|whb|2829@whn|芜湖南|RVH|wuhunan|whn|2830@whx|苇河西|WIB|weihexi|whx|2831@wji|温江|WJE|wenjiang|wj|2832@wjq|魏家泉|WJR|weijiaquan|wjq|2833@wlb|乌兰察布|WPC|wulanchabu|wlcb|2834@wld|五龙背东|WMT|wulongbeidong|wlbd|2835@wln|乌龙泉南|WFN|wulongquannan|wlqn|2836@wlt|乌兰木图|VLT|wulanmutu|wlmt|2837@wnd|望牛墩|WNA|wangniudun|wnd|2838@wns|五女山|WET|wunvshan|wns|2839@wnx|渭南西|WXY|weinanxi|wnx|2840@wsh|武胜|WSE|wusheng|ws|2841@wsq|乌审旗|WGC|wushenqi|wsq|2842@wsu|乌苏|WSR|wusu|ws|2843@wto|五通|WTZ|wutong|wt|2844@wwe|无为|IIH|wuwei|ww|2845@wwn|无为南|WWU|wuweinan|wwn|2846@wws|瓦屋山|WAH|wawushan|wws|2847@wxi|威信|WXE|weixin|wx|2848@wxx|闻喜西|WOV|wenxixi|wxx|2849@wyb|武义北|WDH|wuyibei|wyb|2850@wyb|武夷山北|WBS|wuyishanbei|wysb|2851@wyu|婺源|WYG|wuyuan|wy|2852@wyu|渭源|WEJ|weiyuan|wy|2853@wza|湾仔|WZA|wanzai|wz|2854@wzb|万州北|WZE|wanzhoubei|wzb|2855@wzb|湾仔北|WBA|wanzaibei|wzb|2856@wzh|吴忠|WVJ|wuzhong|wz|2857@wzh|武陟|WIF|wuzhi|wz|2858@wzn|梧州南|WBZ|wuzhounan|wzn|2859@wzn|湾沚南|WNU|wanzhinan|wzn|2860@xab|兴安北|XDZ|xinganbei|xab|2861@xcb|许昌北|EBF|xuchangbei|xcb|2862@xcd|许昌东|XVF|xuchangdong|xcd|2863@xch|项城|ERN|xiangcheng|xc|2864@xdd|新都东|EWW|xindudong|xdd|2865@xdu|西渡|XDA|xidu|xd|2866@xfe|咸丰|XFA|xianfeng|xf|2867@xfe|西丰|XFT|xifeng|xf|2868@xfe|先锋|NQQ|xianfeng|xf|2869@xfl|湘府路|FVQ|xiangfulu|xfl|2870@xfx|襄汾西|XTV|xiangfenxi|xfx|2871@xgb|孝感北|XJN|xiaoganbei|xgb|2872@xgd|新干东|XGG|xingandong|xgd|2873@xgd|孝感东|GDN|xiaogandong|xgd|2874@xgx|兴国西|XIG|xingguoxi|xgx|2875@xgz|夏格庄|XZK|xiagezhuang|xgz|2876@xhb|下花园北|OKP|xiahuayuanbei|xhyb|2877@xhb|兴和北|EBC|xinghebei|xhb|2878@xhb|宣化北|VJP|xuanhuabei|xhb|2879@xhd|西湖东|WDQ|xihudong|xhd|2880@xhn|新化南|EJQ|xinhuanan|xhn|2881@xhu|西华|EHF|xihua|xh|2882@xhx|新晃西|EWQ|xinhuangxi|xhx|2883@xji|新津|IRW|xinjin|xj|2884@xjk|小金口|NKQ|xiaojinkou|xjk|2885@xjn|辛集南|IJP|xinjinan|xjn|2886@xjn|新津南|ITW|xinjinnan|xjn|2887@xla|西来|XLE|xilai|xl|2888@xmb|新民北|XOT|xinminbei|xmb|2889@xme|厦 门|EMS|xiamen|xm|2890@xnd|咸宁东|XKN|xianningdong|xnd|2891@xnn|咸宁南|UNN|xianningnan|xnn|2892@xpn|溆浦南|EMQ|xupunan|xpn|2893@xpx|西平西|EGQ|xipingxi|xpx|2894@xsx|响水县|XSU|xiangshuixian|xsx|2895@xtb|湘潭北|EDQ|xiangtanbei|xtb|2896@xtd|邢台东|EDP|xingtaidong|xtd|2897@xtn|新塘南|NUQ|xintangnan|xtn|2898@xwe|兴文|XNE|xingwen|xw|2899@xwq|西乌旗|XWD|xiwuqi|xwq|2900@xwx|修武西|EXF|xiuwuxi|xwx|2901@xwx|修文县|XWE|xiuwenxian|xwx|2902@xxb|萧县北|QSH|xiaoxianbei|xxb|2903@xxb|新香坊北|RHB|xinxiangfangbei|xxfb|2904@xxd|新乡东|EGF|xinxiangdong|xxd|2905@xxi|萧县|EOH|xiaoxian|xx|2906@xya|岫岩|XXT|xiuyan|xy|2907@xyb|新余北|XBG|xinyubei|xyb|2908@xyc|西阳村|XQF|xiyangcun|xyc|2909@xyd|信阳东|OYN|xinyangdong|xyd|2910@xyd|襄阳东|EKN|xiangyangdong|xyd|2911@xyd|咸阳秦都|XOY|xianyangqindu|xyqd|2912@xyi|秀英|XYA|xiuying|xy|2913@xyo|仙游|XWS|xianyou|xy|2914@xyu|祥云|XQM|xiangyun|xy|2915@xzc|新郑机场|EZF|xinzhengjichang|xzjc|2916@xzl|香樟路|FNQ|xiangzhanglu|xzl|2917@xzx|忻州西|IXV|xinzhouxi|xzx|2918@yan|雅安|YAE|yaan|ya|2919@yan|永安南|YQS|yongannan|yan|2920@ybl|迎宾路|YFW|yingbinlu|ybl|2921@ybx|亚布力西|YSB|yabulixi|yblx|2922@ybx|宜宾西|YXE|yibinxi|ybx|2923@ycb|永城北|RGH|yongchengbei|ycb|2924@ycb|盐城北|AEH|yanchengbei|ycb|2925@ycb|运城北|ABV|yunchengbei|ycb|2926@ycd|禹城东|YSK|yuchengdong|ycd|2927@ycd|永川东|WMW|yongchuandong|ycd|2928@ych|宜春|YEG|yichun|yc|2929@ych|岳池|AWW|yuechi|yc|2930@ydh|云东海|NAQ|yundonghai|ydh|2931@ydu|姚渡|AOJ|yaodu|yd|2932@yfd|云浮东|IXQ|yunfudong|yfd|2933@yfn|永福南|YBZ|yongfunan|yfn|2934@yge|雨格|VTM|yuge|yg|2935@ygn|阳高南|AGV|yanggaonan|ygn|2936@yhe|洋河|GTH|yanghe|yh|2937@yjb|永济北|AJV|yongjibei|yjb|2938@yjx|延吉西|YXL|yanjixi|yjx|2939@ykn|永康南|QUH|yongkangnan|ykn|2940@yla|依兰|YEB|yilan|yl|2941@ylh|运粮河|YEF|yunlianghe|ylh|2942@yli|鄢陵|YIF|yanling|yl|2943@yli|炎陵|YAG|yanling|yl|2944@yln|杨陵南|YEY|yanglingnan|yln|2945@yma|羊马|YME|yangma|ym|2946@ymb|一面坡北|YXB|yimianpobei|ympb|2947@ymd|云梦东|YRN|yunmengdong|ymd|2948@ymi|伊敏|YMX|yimin|ym|2949@ymx|元谋西|AMM|yuanmouxi|ymx|2950@yna|郁南|YKQ|yunan|yn|2951@yny|云南驿|ANM|yunnanyi|yny|2952@ypd|延平东|ADS|yanpingdong|ypd|2953@ypi|延平|YPS|yanping|yp|2954@ypi|银瓶|KPQ|yinping|yp|2955@ypx|延平西|YWS|yanpingxi|ypx|2956@ypx|原平西|IPV|yuanpingxi|ypx|2957@yqh|雁栖湖|FGP|yanqihu|yqh|2958@yqi|杨桥|YQA|yangqiao|yq|2959@yqx|阳曲西|IQV|yangquxi|yqx|2960@yre|永仁|ARM|yongren|yr|2961@ysb|颍上北|YBU|yingshangbei|ysb|2962@ysh|阳朔|YCZ|yangshuo|ys|2963@ysh|永寿|ASY|yongshou|ys|2964@ysh|云山|KZQ|yunshan|ys|2965@ysn|玉山南|YGG|yushannan|ysn|2966@ysn|雁石南|YMS|yanshinan|ysn|2967@yta|永泰|YTS|yongtai|yt|2968@yta|银滩|CTQ|yintan|yt|2969@ytb|鹰潭北|YKG|yingtanbei|ytb|2970@ytn|烟台南|YLK|yantainan|ytn|2971@yto|伊通|YTL|yitong|yt|2972@ytx|烟台西|YTK|yantaixi|ytx|2973@yxi|尤溪|YXS|youxi|yx|2974@yxi|云霄|YBS|yunxiao|yx|2975@yxi|宜兴|YUH|yixing|yx|2976@yxi|玉溪|AXM|yuxi|yx|2977@yxi|阳信|YVK|yangxin|yx|2978@yxi|应县|YZV|yingxian|yx|2979@yxn|攸县南|YXG|youxiannan|yxn|2980@yxx|洋县西|YXY|yangxianxi|yxx|2981@yxx|义县西|YSD|yixianxi|yxx|2982@yyb|余姚北|CTH|yuyaobei|yyb|2983@yzh|禹州|YZF|yuzhou|yz|2984@yzh|榆中|IZJ|yuzhong|yz|2985@zan|诏安|ZDS|zhaoan|za|2986@zbb|淄博北|ZRK|zibobei|zbb|2987@zdc|正定机场|ZHP|zhengdingjichang|zdjc|2988@zdo|准东|ZER|zhundong|zd|2989@zfd|纸坊东|ZMN|zhifangdong|zfd|2990@zga|柘皋|ZGU|zhegao|zg|2991@zge|准格尔|ZEC|zhungeer|zge|2992@zhb|庄河北|ZUT|zhuanghebei|zhb|2993@zhl|珠海长隆|ZLA|zhuhaichanglong|zhcl|2994@zhu|昭化|ZHW|zhaohua|zh|2995@zjb|织金北|ZJE|zhijinbei|zjb|2996@zjc|张家川|ZIJ|zhangjiachuan|zjc|2997@zjg|张家港|ZAU|zhangjiagang|zjg|2998@zji|芷江|ZPQ|zhijiang|zj|2999@zji|织金|IZW|zhijin|zj|3000@zjn|张家口南|IXP|zhangjiakounan|zjkn|3001@zjx|张家界西|JXA|zhangjiajiexi|zjjx|3002@zka|仲恺|KKQ|zhongkai|zk|3003@zkd|周口东|ZKF|zhoukoudong|zkd|3004@zko|曾口|ZKE|zengkou|zk|3005@zli|珠琳|ZOM|zhulin|zl|3006@zli|左岭|ZSN|zuoling|zl|3007@zmd|樟木头东|ZRQ|zhangmutoudong|zmtd|3008@zmx|驻马店西|ZLN|zhumadianxi|zmdx|3009@zpi|邹平|ZLK|zouping|zp|3010@zpu|漳浦|ZCS|zhangpu|zp|3011@zpx|漳平西|ZXG|zhangpingxi|zpx|3012@zqb|章丘北|ZVK|zhangqiubei|zqb|3013@zqd|肇庆东|FCQ|zhaoqingdong|zqd|3014@zqi|庄桥|ZQH|zhuangqiao|zq|3015@zsh|昭山|KWQ|zhaoshan|zs|3016@zsx|钟山西|ZAZ|zhongshanxi|zsx|3017@zsz|朱砂古镇|ZSE|zhushaguzhen|zsgz|3018@zta|中堂|ZTA|zhongtang|zt|3019@zwn|中卫南|ZTJ|zhongweinan|zwn|3020@zxi|镇雄|ZXE|zhenxiong|zx|3021@zxi|漳县|ZXJ|zhangxian|zx|3022@zyb|资阳北|FYW|ziyangbei|zyb|3023@zyi|遵义|ZYE|zunyi|zy|3024@zyn|遵义南|ZNE|zunyinan|zyn|3025@zyx|张掖西|ZEJ|zhangyexi|zyx|3026@zzb|资中北|WZW|zizhongbei|zzb|3027@zzd|枣庄东|ZNK|zaozhuangdong|zzd|3028@zzd|涿州东|ZAP|zhuozhoudong|zzd|3029@zzd|卓资东|ZDC|zhuozidong|zzd|3030@zzd|郑州东|ZAF|zhengzhoudong|zzd|3031@zzn|株洲南|KVQ|zhuzhounan|zzn|3032");
		String[] allsStations =  buf.toString().split("@");
		System.out.println("总数："+allsStations.length);
		for (String station : allsStations) {
			System.out.println("-------------");
			System.out.println(station);
			if (StringUtils.isNotBlank(station)){
				List<String> strlist = Arrays.asList(station.split("\\|"));
				for (String s : strlist) {
					System.out.println(s);
				}
			}
		}

	}
}
