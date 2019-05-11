package com.sh.tpsdt.constants;

import com.sh.tpsdt.model.brute_meter.BruteMeterRule;
import com.sh.tpsdt.model.brute_meter.BruteMeterStandard;
import com.sh.tpsdt.model.heat_structure.HeatStructureRule;
import com.sh.tpsdt.model.heat_structure.HeatStructureStandard;

import java.util.Arrays;
import java.util.List;

/**
 * @program: tpsdt
 * @description:
 * @author:
 * @create: 2019-03-14 14:21
 **/
public interface CommandConstants {

    String COMMAND_BRUTE_METER = "==== 频度划分的暴力攻击算法评估：";

    String COMMAND_LENGTH_TITLE = "==== 口令长度：";

    String COMMAND_GRAMMAR_TITLE = "==== 语法结构：";

    String COMMAND_SYNTACTIC_TITLE = "==== 句法结构：";

    String COMMAND_SYNTACTIC_CONTENT = "句法结构：";

    String COMMAND_PERSON_PREFER_TITLE = "==== 个人信息相关：";

    String COMMAND_POINT_TITLE = "==== 综合口令强弱：";

    String COMMAND_RECOMMEND = "推荐口令：";

    String COMMAND_HEAT_STRUCTURE_TITLE = "==== 基于热词与结构攻击算法评估：";

    String AZ_VOWEL = "[aoeiu]";

    String AZ_HIGH = "[nlrstmcdy]";

    String AZ_LOW = "[hbkgpvjfzwxq]";

    String AZ = "[A-Z]";

    String NUM09 = "[0-9]";

    String AZ_UPPER = "[ABCDEFGHIJKLMNOPQRSTUVWXYZ]";

    String AZ_LOWER = "[abcdefghijklmnopqrstuvwxyz]";

    String SP = "[._!-*@#/$,+&\\)=?(';]%<~[:^`\">{}|]";

    String SP_HIGH = "[._!-*@#/]";

    String SP_LOW = "[$,+&\\)=?(';]%<~[:^`\">{}|]";

    String AZ_VOWEL_TITLE = "元音字母";

    String AZ_HIGH_TITLE = "高频小写字母";

    String AZ_LOW_TITLE = "低频小写字母";

    String AZ_TITLE = "大写字母";

    String NUM09_TITLE = "数字";

    String SP_TITLE = "键盘特殊字符";

    String CHINESE_WORD = "/^[\\u4e00-\\u9fa5]+$/";

    String DATE = "/((?!0000)[0-9]{4}-((0[1-9]|1[0-2])-(0[1-9]|1[0-9]|2[0-8])|(0[13-9]|1[0-2])-(29|30)|(0[13578]|1[02])-31)|([0-9]{2}(0[48]|[2468][048]|[13579][26])|(0[48]|[2468][048]|[13579][26])00)-02-29)/";

    String EMAIL = "/[\\w!#$%&'*+/=?^_`{|}~-]+(?:\\.[\\w!#$%&'*+/=?^_`{|}~-]+)*@(?:[\\w](?:[\\w-]*[\\w])?\\.)+[\\w](?:[\\w-]*[\\w])?/";

    String MAC = "/([A-Fa-f0-9]{2}-){5}[A-Fa-f0-9]{2}/";

    String ID_CARD = "/^(\\d{6})(\\d{4})(\\d{2})(\\d{2})(\\d{3})([0-9]|X)$/";

    String IP = "/((25[0-5]|2[0-4]\\d|((1\\d{2})|([1-9]?\\d)))\\.){3}(25[0-5]|2[0-4]\\d|((1\\d{2})|([1-9]?\\d)))/";

    String TIMER_24 = "^(0[0-9]|1[0-9]|2[0-3]):[0-5][0-9](:[0-5][0-9])?$";

    String TIMER_12 = "0[0-9]:[0-5][0-9]|1[0-1]:[0-5][0-9]";

    String HTML_TAG = "<(S*?)[^>]*>.*?|<.*? />";

    String URL = "[a-zA-z]+://[^s]*";

    String INNER_PHONE = "d{3}-d{8}|d{4}-d{7}";

    String QQ_NUM = "[1-9][0-9]{4,}";

    String INNER_CODE = "[1-9]d{5}(?!d) ";

    List<BruteMeterRule> BRUTE_METER_RULES = Arrays.asList(
            //SUPER LOW =================================================================================================================
            new BruteMeterRule(NUM09 + "{1,2}", Math.pow(10, 6), "2位纯数字"),
            new BruteMeterRule(AZ_LOWER + "{1,2}", Math.pow(10, 6), "2位以内小写字母"),
            new BruteMeterRule(AZ_VOWEL + "{1,2}", Math.pow(10, 6), "2位以内小写元音字母"),
            new BruteMeterRule(AZ_HIGH + "{1,2}", Math.pow(10, 6), "2位以内大写字母"),
            new BruteMeterRule(SP + "{1,2}", Math.pow(10, 6), "2位以为特殊字符"),
            new BruteMeterRule(CHINESE_WORD + "+", 10d, "纯中文"),
            new BruteMeterRule(EMAIL, 10d, "个人邮件"),
            new BruteMeterRule(MAC, 10d, "笔记本MAC地址"),
            new BruteMeterRule(ID_CARD, 10d, "身份证信息"),
            new BruteMeterRule(IP, 10d, "IP地址"),
            new BruteMeterRule(DATE, 10d, "日期格式"),
            new BruteMeterRule(TIMER_24, 10d, "24小时"),
            new BruteMeterRule(TIMER_12, 10d, "12小时"),
            new BruteMeterRule(HTML_TAG, 10d, "HTML标签"),
            new BruteMeterRule(URL, 10d, "URL"),
            new BruteMeterRule(INNER_PHONE, 10d, "国内电话"),
            new BruteMeterRule(QQ_NUM, 10d, "QQ号码"),
            new BruteMeterRule(INNER_CODE, 10d, "国内邮政编码"),
            new BruteMeterRule(NUM09 + "{4}", 10036d, "4位数字"),
            new BruteMeterRule(AZ_HIGH + AZ_VOWEL, 10081d, "大写字母加元音字母"),
            new BruteMeterRule(NUM09 + "{2}", 10181d, "2位数字"),
            new BruteMeterRule(NUM09 + "{5}", 110181d, "5位数字"),
            new BruteMeterRule(AZ_HIGH + AZ_VOWEL + AZ_HIGH, 110586d, "大写字母夹杂元音字母"),
            new BruteMeterRule(AZ_LOW + AZ_VOWEL, 110646d, "小写字母加元音字母"),
            new BruteMeterRule(NUM09 + "{6}", 1.11 * Math.pow(10, 6), ""),
            new BruteMeterRule(AZ_HIGH + AZ_VOWEL + AZ_HIGH + AZ_VOWEL, 1.11 * Math.pow(10, 6), "大写字母加元音加大写字母加元音字母"),
            new BruteMeterRule(AZ_HIGH + "{2}", 1.11 * Math.pow(10, 6), ""),
            new BruteMeterRule(AZ_VOWEL + AZ_HIGH + AZ_VOWEL, 1.11 * Math.pow(10, 6), "元音字母加大写字母加元音字母"),
            new BruteMeterRule(AZ_HIGH + AZ_VOWEL + AZ_HIGH + AZ_VOWEL + AZ_HIGH, 1.13 * Math.pow(10, 6), "大写字母加元音字母加大写字母加元音字母加大写字母"),
            new BruteMeterRule(AZ_HIGH + AZ_VOWEL + "{2}", 1.13 * Math.pow(10, 6), "大写字母加元音字母"),
            new BruteMeterRule(AZ_HIGH + AZ_LOW, 1.13 * Math.pow(10, 6), "大写字母加小写字母"),
            new BruteMeterRule(AZ_VOWEL + AZ_LOW, 1.13 * Math.pow(10, 6), "元音字母加小写字母"),
            new BruteMeterRule(NUM09 + "{2}", 1.13 * Math.pow(10, 6), ""),
            new BruteMeterRule(AZ_LOW + AZ_VOWEL + AZ_HIGH, 1.13 * Math.pow(10, 6), "小写字母加元音字母加大写字母"),
            //LOW =====================================================================================================================
            new BruteMeterRule(NUM09 + "{3,5}", Math.pow(10, 6), "3-5位纯数字"),
            new BruteMeterRule(AZ_LOWER + "{3,5}", Math.pow(10, 6), "3-5位以内小写字母"),
            new BruteMeterRule(AZ_VOWEL + "{3,5}", Math.pow(10, 6), "3-5位以内小写元音字母"),
            new BruteMeterRule(AZ_HIGH + "{3,5}", Math.pow(10, 6), "3-5位以内大写字母"),
            new BruteMeterRule(SP + "{3,5}", Math.pow(10, 6), "3-5位以为特殊字符"),
            new BruteMeterRule("([\\d])\\1{3}", BruteMeterStandard.LOW, "3位数字"),
            new BruteMeterRule(AZ_VOWEL + "{5}", BruteMeterStandard.LOW, "5位元音字母"),
            new BruteMeterRule(AZ_HIGH + "{5}", BruteMeterStandard.LOW, "5位大写字母"),
            new BruteMeterRule(AZ_LOW + "{5}", BruteMeterStandard.LOW, "5位小写字母"),
            new BruteMeterRule(NUM09 + "{4}", BruteMeterStandard.LOW, "4位数字"),
            new BruteMeterRule(AZ_HIGH + AZ_VOWEL, BruteMeterStandard.LOW, "大写字母加元音字母"),
            new BruteMeterRule(AZ_HIGH + AZ_VOWEL + AZ_HIGH, BruteMeterStandard.LOW, "大写字母加元音字母加大写字母"),
            new BruteMeterRule(AZ_LOW + AZ_VOWEL, BruteMeterStandard.LOW, "小写字母加元音字母"),
            new BruteMeterRule(AZ_HIGH + AZ_VOWEL + AZ_HIGH + AZ_VOWEL, BruteMeterStandard.LOW, "大写字母加元音字母加大写字母加元音字母"),
            new BruteMeterRule(AZ_HIGH + "{2}", BruteMeterStandard.LOW, "2位大写字母"),
            new BruteMeterRule(AZ_VOWEL + AZ_HIGH + AZ_VOWEL, BruteMeterStandard.LOW, "元音字母加大写字母加元音字母"),
            new BruteMeterRule(AZ_HIGH + AZ_VOWEL + AZ_HIGH + AZ_VOWEL + AZ_HIGH, BruteMeterStandard.LOW, "大写字母加元音字母加大写字母加元音字母加大写字母"),
            new BruteMeterRule(AZ_HIGH + AZ_VOWEL + "{2}", BruteMeterStandard.LOW, "大写字母加元音字母"),
            new BruteMeterRule(AZ_HIGH + AZ_LOW, BruteMeterStandard.LOW, "大写字母加小写字母"),
            new BruteMeterRule(AZ_VOWEL + AZ_LOW, BruteMeterStandard.LOW, "元音字母加小写字母"),
            new BruteMeterRule(AZ_LOW + AZ_VOWEL + AZ_HIGH, BruteMeterStandard.LOW, "小写字母加元音字母加大写字母"),
            //MEDIUM===================================================================================================================
            new BruteMeterRule(NUM09 + "{6,7}", Math.pow(10, 6), "3-5位纯数字"),
            new BruteMeterRule(AZ_LOWER + "{6,7}", Math.pow(10, 6), "3-5位以内小写字母"),
            new BruteMeterRule(AZ_VOWEL + "{6,7}", Math.pow(10, 6), "3-5位以内小写元音字母"),
            new BruteMeterRule(AZ_HIGH + "{6,7}", Math.pow(10, 6), "3-5位以内大写字母"),
            new BruteMeterRule(SP + "{6,7}", Math.pow(10, 6), "3-5位以为特殊字符"),
            new BruteMeterRule(NUM09 + "{6,8}", BruteMeterStandard.MEDIUM, "8位纯数字"),
            new BruteMeterRule(AZ_HIGH + "{4}" + AZ_VOWEL, BruteMeterStandard.MEDIUM, "4位大写字母加元音字母"),
            new BruteMeterRule(NUM09 + AZ_VOWEL + "{4}", BruteMeterStandard.MEDIUM, "小写数字加4位元音字母"),
            new BruteMeterRule(NUM09 + AZ_LOW + "{4}", BruteMeterStandard.MEDIUM, "小写数字加4位小写字母"),
            new BruteMeterRule(AZ_HIGH + "{3}" + AZ_VOWEL + AZ_HIGH, BruteMeterStandard.MEDIUM, "3位大写字母加元音字母加大写字母"),
            new BruteMeterRule(AZ_LOW + AZ_VOWEL + "{4}", BruteMeterStandard.MEDIUM, "小写字母加4位元音字母"),
            new BruteMeterRule(AZ_HIGH + AZ_VOWEL + AZ_HIGH + "{3}" + AZ_VOWEL, BruteMeterStandard.MEDIUM, "大写字母加元音字母加3位大写字母加元音字母"),
            new BruteMeterRule(NUM09 + AZ_HIGH + "{4}", BruteMeterStandard.MEDIUM, "数字加4位大写字母"),
            new BruteMeterRule(AZ_VOWEL + AZ_HIGH + AZ_VOWEL + "{3}", BruteMeterStandard.MEDIUM, "元音字母加大写字母加3位元音字母"),
            new BruteMeterRule(AZ_HIGH + AZ_VOWEL + AZ_HIGH + AZ_VOWEL + AZ_HIGH, BruteMeterStandard.MEDIUM, "大写字母加元音字母加大写字母加元音字母加大写字母"),
            new BruteMeterRule(AZ_HIGH + "{3}" + AZ_VOWEL + "{2}", BruteMeterStandard.MEDIUM, "3位大写字母加2位元音字母"),
            new BruteMeterRule(AZ_HIGH + AZ_LOW + NUM09 + "{3}", BruteMeterStandard.MEDIUM, "大写字母加小写字母加3位数字"),
            new BruteMeterRule(AZ_VOWEL + "{3}" + AZ_LOW + NUM09, BruteMeterStandard.MEDIUM, "3位元音字母加小写字母加数字"),
            new BruteMeterRule(NUM09 + "{2}" + AZ_VOWEL + "{3}", BruteMeterStandard.MEDIUM, "2位数字加3位元音字母"),
            new BruteMeterRule(AZ_LOW + AZ_VOWEL + "{3}" + AZ_HIGH, BruteMeterStandard.MEDIUM, "小写字母加3位元音加大写字母"),
            new BruteMeterRule("^(?![0-9]+$)(?![a-zA-Z]+$)[0-9A-Za-z._!-\\*@#/$,+&\\)=?(';]%<~[:^`\">{}|]{4,5}$", BruteMeterStandard.SUPER_HIGH, "4到5位由数字字母特殊字符混合而成"),
            //HIGH======================================================================================================================
            new BruteMeterRule(NUM09 + "{8,}", Math.pow(10, 6), "3-5位纯数字"),
            new BruteMeterRule(AZ_LOWER + "{8,}", Math.pow(10, 6), "3-5位以内小写字母"),
            new BruteMeterRule(AZ_VOWEL + "{8,}", Math.pow(10, 6), "3-5位以内小写元音字母"),
            new BruteMeterRule(AZ_HIGH + "{8,}", Math.pow(10, 6), "3-5位以内大写字母"),
            new BruteMeterRule(SP + "{8,}", Math.pow(10, 6), "3-5位以为特殊字符"),
            new BruteMeterRule(NUM09 + "{4}" + SP + "{3}", BruteMeterStandard.HIGH, "4位数字加3位特殊字符"),
            new BruteMeterRule(AZ_HIGH + AZ_VOWEL + "{3}" + SP + "{3}", BruteMeterStandard.HIGH, "大写字母加3位元音字母加3位特俗字符"),
            new BruteMeterRule(NUM09 + "{2}" + SP + "{5}", BruteMeterStandard.HIGH, "2位数字加5位特殊字符"),
            new BruteMeterRule(NUM09 + "{5}" + SP + "{3}", BruteMeterStandard.HIGH, "5位数字加3位特殊字符"),
            new BruteMeterRule(AZ_HIGH + AZ_VOWEL + AZ_HIGH + SP + "{4}", BruteMeterStandard.HIGH, "大写字母加元音字母加大写字母加4位特殊字符"),
            new BruteMeterRule(AZ_LOW + AZ_VOWEL + SP + "{5}", BruteMeterStandard.HIGH, "小写字母加元音字母加5位特殊字符"),
            new BruteMeterRule(NUM09 + "{6}" + SP + "{1}", BruteMeterStandard.HIGH, "6位字母加1位特殊字符"),
            new BruteMeterRule(AZ_HIGH + AZ_VOWEL + AZ_HIGH + AZ_VOWEL + SP + "{3}", BruteMeterStandard.HIGH, "大写字母加元音字母加大写字母加元音字母加3位特殊字母"),
            new BruteMeterRule(AZ_HIGH + "{2}" + SP + "{5}", BruteMeterStandard.HIGH, "2位大写字母加5位特殊字母"),
            new BruteMeterRule(AZ_VOWEL + AZ_HIGH + AZ_VOWEL + SP + "{4}", BruteMeterStandard.HIGH, "元音字母加大写字母加元音字母加4位特殊字符"),
            new BruteMeterRule(AZ_HIGH + AZ_VOWEL + AZ_HIGH + SP + "{2}" + AZ_VOWEL + AZ_HIGH, BruteMeterStandard.HIGH, "大写字母加2位元音字符加大写字母加2位特殊字符"),
            new BruteMeterRule(AZ_HIGH + AZ_VOWEL + "{2}" + SP + "{4}", BruteMeterStandard.HIGH, "大写字母加2位小写元音字母加4位特殊字符"),
            new BruteMeterRule(AZ_HIGH + AZ_LOW + SP + "{5}", BruteMeterStandard.HIGH, "大写字母加小写字母加5位特殊字符"),
            new BruteMeterRule(AZ_VOWEL + AZ_LOW + SP + "{5}", BruteMeterStandard.HIGH, "元音字母加小写字母加5位特殊字符"),
            new BruteMeterRule(SP + "{2}" + NUM09 + "{2}" + SP + "{2}" + AZ_VOWEL, BruteMeterStandard.HIGH, "2位特殊字符加2位数字加2位特殊字符加1位元音字母"),
            new BruteMeterRule(AZ_LOW + SP + "{2}" + AZ_VOWEL + AZ_HIGH + SP + "{2}", BruteMeterStandard.HIGH, "小写字母加2位特殊字符加元音字母加大写字母加2位特殊字符"),
            new BruteMeterRule("^(?![0-9]+$)(?![a-zA-Z]+$)[0-9A-Za-z._!-\\*@#/$,+&\\)=?(';]%<~[:^`\">{}|]{5,8}$", BruteMeterStandard.SUPER_HIGH, "5到8位由数字字母特殊字符混合而成"),
            //SUPER HIGH==================================================================================================================
            new BruteMeterRule("^(?![0-9]+$)(?![a-zA-Z]+$)[0-9A-Za-z._!-\\*@#/$,+&\\)=?(';]%<~[:^`\">{}|]{8,}$", BruteMeterStandard.SUPER_HIGH, "8位以上由数字字母特殊字符混合而成")

    );

    String NA_3 = "(Abe|Aly|Ann|Ben|Bob|Dan|Eva|Eve|Fox|Gus|Guy|Hal|Jim|Job|Joe|Kit|Law|Lee|Lew|Max|May|Meg|Peg|Poe|Rob|Roy|Sam|Ted|Tom|Van|Wat)";
    String NA_4 = "(Adam|Anna|Anne|Bach|Bart|Beck|Bell|Bert|Bess|Bill|Bray|Buck|Camp|Carl|Davy|Den|Dick|Dodd|Dora|Dutt|Eden|Edie|Ella|Emma|Evan|Fast|Finn|Ford|Fred|Funk|Gill|Gold|Gray|Grey|Hart|Hill|Holt|Hood|Hope|Hugh|Hume|Hutt|Ivan|Jack|Jane|Jean|Joan|Joel|John|Josh|Judd|Lamb|Lena|Lily|Lou|Lucy|Luke|Lyly|Lynd|Mark|Mary|Maud|Mike|Mill|Moll|Mond|More|Nell|Nick|Noah|Noel|Nora|Owen|Paul|Penn|Pope|Reed|Rhys|Rosa|Rose|Rusk|Ruth|Saul|Shaw|Snow|Tate|Toby|Tony|Tout|Vogt|Ward|Watt|Webb|Whit|Wild|Will|Wolf|Wood|Yale|Yule)";
    String NA_5 = "(Adams|Adela|Agnes|Aled|Alice|Alick|Bacon|Bauer|Beard|Becky|Belle|Betsy|Betty|Billy|Black|Blake|Bloor|Blume|Bobby|Bowen|Boyle|Broad|Brown|Bruce|Bruno|Bryan|Bryce|Burke|Burns|Byron|Carey|Child|Clara|Clare|Conan|Cook|Crane|Croft|Curme|Daisy|David|Defoe|Delia|Dewar|Dewey|Dolly|Donne|Doris|Doyle|Eddie|Edith|Effie|Eliot|Ellen|Ellis|Elsie|Emily|Eugen|Evans|Fanny|Felix|Field|Flynn|Frank|Gard|Giles|Gosse|Grace|Grant|Green|Grote|Hardy|Harry|Harte|Haydn|Henry|Herty|Hicks|Hodge|Hosea|House|Hoyle|Isaac|Jacob|James|Jenny|Jerry|Jimmy|Jonah|Jones|Joule|Joyce|Julia|Katte|Keats|Kell|Kitto|Kitty|Leigh|Lewis|Lloyd|Locke|Louis|Lucas|Lucia|Lynch|Madge|Malan|Maltz|Maria|Micah|Milne|Moore|Morse|Moses|Nahum|Nancy|Nelly|Nico|Nixon|North|Noyes|Occam|Oscar|Pansy|Pater|Peggy|Pepys|Peter|Petty|Piers|Pigou|Polly|Pound|Price|Pritt|Ralph|Raman|Reade|Robin|Roger|Romeo|Sally|Sandy|Sapir|Sara|Scott|Sharp|Silas|Simon|Smith|Sophy|Stone|Stowe|Susan|Sweet|Swift|Terry|Titus|Tommy|Tours|Tracy|Twain|Tyler|Walsh|Wells|Whyet|Wilde|Woolf|Wyat|Wyld|Young)";
    String NA_6 = "(Abbot|Adolph|Albert|Alcott|Alfred|Alsop|Amelia|Andrew|Arnold|Arthur|Attlee|Austen|Austin|Barney|Barrie|Barton|Becher|Belloc|Benson|Bernal|Bertha|Bertie|Bessie|Bowman|Bright|Bronte|Brooke|Browne|Buckle|Bulwer|Bunyan|Butler|Carmen|Carrie|Carter|Childe|Christ|Church|Cissie|Clark|Cocker|Coffey|Connie|Connor|Conrad|Cooper|Cotton|Cowper|Crofts|Cronin|Dalton|Daniel|Darwin|Dickey|Dillon|Dobbin|Dryden|DuBois|Dulles|Dunbar|Duncan|Dunlop|Dupont|Edison|Edmund|Edward|Elinor|Emmie|Ernest|Esther|Eugene|Felton|Flower|Foster|Fowler|Gallup|Garcia|Garden|George|Gibbon|Gibson|Godwin|Gracie|Graham|Gunter|Haggai|Hamlet|Hansen|Hansom|Harold|Harper|Harrod|Harvey|Hearst|Helin|Henley|Hobbes|Hobson|Holmes|Hoover|Horace|Hornby|Howard|Hudson|Hughes|Huxley|Irving|Isabel|Isaiah|Jasper|Jeames|Jeremy|Jerome|Jessie|Johnny|Jonson|Jordan|Joseph|Joshua|Judith|Judson|Julian|Juliet|Julius|Kelsen|Kelvin|Kennan|Keppel|Keynes|Landon|Larkin|Laurie|Lawson|Lizzie|London|Louisa|Louise|Lowell|Lucius|Lytton|Maggie|Malory|Marcus|Marion|Marner|Martha|Martin|Milton|Minnie|Monroe|Morgan|Morley|Morris|Morton|Motley|Murray|Nelson|Newman|Newton|Norris|Norton|Oliver|O’Neil|Onions|Palmer|Parker|Perkin|Philip|Pitman|Powell|Pullan|Raglan|Rhodes|Robert|Roland|Ruskin|Salome|Samson|Samuel|Sander|Sawyer|Saxton|Senior|Sidney|Sophia|Steele|Stella|Strong|Stuart|Surrey|Symons|Taylor|Temple|Thomas|Tobias|Toland|Truman|Turner|Tuttle|Veblen|Victor|Violet|Wagner|Walker|Wallis|Walter|Walton|Warner|Warren|Waters|Wesley|Wilcox|Wilson|Wright|Yeates|Yerkes)";
    String NA_7 = "(Abraham|Acheson|Addison|Anthony|Antonia|Babbitt|Baldwin|Barnard|Barrett|Bellamy|Bennett|Bentham|Bernard|Bertram|Bethune|Birrell|Bloomer|Boswell|Bradley|Bridges|Camilla|Carroll|Chaplin|Chapman|Charles|Charley|Charles|Chaucer|Christy|Clapham|Clemens|Clement|Collins|Commons|Craigie|Daniell|Dickens|Doherty|Dorothy|Dierser|Eleanor|Electra|Emerson|Evelina|Ezekiel|Faraday|Forster|Frances|Francis|Freeman|Gabriel|Gaskell|Geordie|Gilbert|Gissing|Gregory|Gresham|Gunther|Halifax|Haywood|Hazlitt|Herbert|Hewlett|Hodgson|Hopkin|Horatio|Housman|Houston|Howell|Hubbard|Huggins|Humphr|Jackson|Jenkin|Johnson|Juliana|Katrine|Kellogg|Kennedy|Kipling|Lambert|Leacock|Leonard|Leopold|Lincoln|Lindsay|Longman|MacAdam|Malachi|Malthus|Margery|Marjory|Marlowe|Matthew|Maugham|Maurice|Maxwell|Michael|Moulton|Needham|Nichol|Obadiah|O’Casey|Orlando|Patrick|Peacock|Pearson|Pollitt|Pullman|Quiller|Raleign|Ramsden|Raphael|Raymond|Rebecca|Ricardo|Richard|Robbins|Robeson|Russell|Saroyan|Sassoon|Scripps|Service|Shelley|Simpson|Smedley|Southey|Spencer|Spender|Spenser|Stephen|Susanna|Thodore|Theresa|Thomson|Thoreau|Timothy|Toynbee|Ulysses|Vaughan|Vincent|Walkley|Wallace|Walpole|Webster|Wheeler|Whitman|Willard|William|Wilmot|Windsor|Woolley|Wyclif)";
    String NA_8 = "(Adelaide|Aldridge|Anderson|Arabella|Augustus|Bartlett|Beaufort|Beerbohm|Benedict|Benjamin|Berkeley|Bessemer|Brewster|Browning|Carllyle|Carnegie|Caroline|Cecillia|Christie|Clarissa|Congreve|Crichton|Cromwell|Dorothea|Douglas|Eipstein|Euphemia|Eveline|Faulkner|Ferguson|Fielding|Franklin|Geoffrey|Grantham|Habakkuk|Hamilton|Harriman|Harrison|Jennings|Jeremiah|Jonathan|Kathleen|Kingsley|Lancelot|Lawrence|Leighton|Macaulay|Margaret|Marshall|Mathilda|McCarthy|McDonald|Melville|Meredith|Morrison|Nehemiah|Nicholas|O’Connor|Patience|Philemon|Pulitzer|Rayleign|Reynolds|Richards|Robinson|Rosalind|Rossetti|Rudolph|Sheridan|Sherwood|Sinclair|Smollett|Stephens|Stilwell|Strachey|Tennyson|Thompson|Trollpoe|Virginia|Wheatley|Whittier|Winifred|Wodehous|Zangwill)";
    String NA_9 = "(Ackerman|Aldington|Alexander|Archibald|Armstrong|Augustine|Carpenter|Charlotte|Christian|Churchill|Colclough|Coleridge|Constance|Coverdale|DeQuincey|Edgeworth|Elizabeth|Ferdinand|Frederick|Galbraith|Gallacher|Gladstone|Goldsmith|Hawthorne|Hemingway|Henrietta|Ingersoll|Jefferson|Johnston|Katharine|Lattimore|Lindberg|MacArthur|Mansfield|Marcellus|Masefield|Michelson|Middleton|Nathaniei|Partridge|Priestley|Roosevelt|Sainsbury|Sailsbury|Steinbeck|Stevenson|Swinburne|Thackeray|Thorndike|Tomlinson|Trevelyan|Valentine|Whitehead|Wollaston|Zacharias|Zechariah|Zephaniah|Zimmerman)";
    String NA_10 = "(Antoinette|Bloomfield|Catharine|Chesterton|Christiana|Cumberland|Eisenhower|FitzGerald|Galsworthy|Harrington|Huntington|Longfellow|MacDonald|Mackintosh|MacMillan|Montgomery|Richardson|Rutherford|Springhall|Washington|Wilhelmina|Wordsworth)";
    String NA_11 = "(Bartholomew|Burne-Jones|Chamberlain|Christopher|Copperfield|MacPherson|Rockefeller|Shakespeare|Sonmerfield)";

    String NA_3_LOWER = "(abe|aly|ann|ben|bob|dan|eva|eve|fox|gus|guy|hal|jim|job|joe|kit|law|lee|lew|max|may|meg|peg|poe|rob|roy|sam|ted|tom|van|wat)";
    String NA_4_LOWER = "(adam|anna|anne|bach|bart|beck|bell|bert|bess|bill|bray|buck|camp|carl|davy|den|dick|dodd|dora|dutt|eden|edie|ella|emma|evan|fast|finn|ford|fred|funk|gill|gold|gray|grey|hart|hill|holt|hood|hope|hugh|hume|hutt|ivan|jack|jane|jean|joan|joel|john|josh|judd|lamb|lena|lily|lou|lucy|luke|lyly|lynd|mark|mary|maud|mike|mill|moll|mond|more|nell|nick|noah|noel|nora|owen|paul|penn|pope|reed|rhys|rosa|rose|rusk|ruth|saul|shaw|snow|tate|toby|tony|tout|vogt|ward|watt|webb|whit|wild|will|wolf|wood|yale|yule)";
    String NA_5_LOWER = "(adams|adela|agnes|aled|alice|alick|bacon|bauer|beard|becky|belle|betsy|betty|billy|black|blake|bloor|blume|bobby|bowen|boyle|broad|brown|bruce|bruno|bryan|bryce|burke|burns|byron|carey|child|clara|clare|conan|cook|crane|croft|curme|daisy|david|defoe|delia|dewar|dewey|dolly|donne|doris|doyle|eddie|edith|effie|eliot|ellen|ellis|elsie|emily|eugen|evans|fanny|felix|field|flynn|frank|gard|giles|gosse|grace|grant|green|grote|hardy|harry|harte|haydn|henry|herty|hicks|hodge|hosea|house|hoyle|isaac|jacob|james|jenny|jerry|jimmy|jonah|jones|joule|joyce|julia|katte|keats|kell|kitto|kitty|leigh|lewis|lloyd|locke|louis|lucas|lucia|lynch|madge|malan|maltz|maria|micah|milne|moore|morse|moses|nahum|nancy|nelly|nico|nixon|north|noyes|occam|oscar|pansy|pater|peggy|pepys|peter|petty|piers|pigou|polly|pound|price|pritt|ralph|raman|reade|robin|roger|romeo|sally|sandy|sapir|sara|scott|sharp|silas|simon|smith|sophy|stone|stowe|susan|sweet|swift|terry|titus|tommy|tours|tracy|twain|tyler|walsh|wells|whyet|wilde|woolf|wyat|wyld|young)";
    String NA_6_LOWER = "(abbot|adolph|albert|alcott|alfred|alsop|amelia|andrew|arnold|arthur|attlee|austen|austin|barney|barrie|barton|becher|belloc|benson|bernal|bertha|bertie|bessie|bowman|bright|bronte|brooke|browne|buckle|bulwer|bunyan|butler|carmen|carrie|carter|childe|christ|church|cissie|clark|cocker|coffey|connie|connor|conrad|cooper|cotton|cowper|crofts|cronin|dalton|daniel|darwin|dickey|dillon|dobbin|dryden|dubois|dulles|dunbar|duncan|dunlop|dupont|edison|edmund|edward|elinor|emmie|ernest|esther|eugene|felton|flower|foster|fowler|gallup|garcia|garden|george|gibbon|gibson|godwin|gracie|graham|gunter|haggai|hamlet|hansen|hansom|harold|harper|harrod|harvey|hearst|helin|henley|hobbes|hobson|holmes|hoover|horace|hornby|howard|hudson|hughes|huxley|irving|isabel|isaiah|jasper|jeames|jeremy|jerome|jessie|johnny|jonson|jordan|joseph|joshua|judith|judson|julian|juliet|julius|kelsen|kelvin|kennan|keppel|keynes|landon|larkin|laurie|lawson|lizzie|london|louisa|louise|lowell|lucius|lytton|maggie|malory|marcus|marion|marner|martha|martin|milton|minnie|monroe|morgan|morley|morris|morton|motley|murray|nelson|newman|newton|norris|norton|oliver|o’neil|onions|palmer|parker|perkin|philip|pitman|powell|pullan|raglan|rhodes|robert|roland|ruskin|salome|samson|samuel|sander|sawyer|saxton|senior|sidney|sophia|steele|stella|strong|stuart|surrey|symons|taylor|temple|thomas|tobias|toland|truman|turner|tuttle|veblen|victor|violet|wagner|walker|wallis|walter|walton|warner|warren|waters|wesley|wilcox|wilson|wright|yeates|yerkes)";
    String NA_7_LOWER = "(abraham|acheson|addison|anthony|antonia|babbitt|baldwin|barnard|barrett|bellamy|bennett|bentham|bernard|bertram|bethune|birrell|bloomer|boswell|bradley|bridges|camilla|carroll|chaplin|chapman|charles|charley|charles|chaucer|christy|clapham|clemens|clement|collins|commons|craigie|daniell|dickens|doherty|dorothy|dierser|eleanor|electra|emerson|evelina|ezekiel|faraday|forster|frances|francis|freeman|gabriel|gaskell|geordie|gilbert|gissing|gregory|gresham|gunther|halifax|haywood|hazlitt|herbert|hewlett|hodgson|hopkin|horatio|housman|houston|howell|hubbard|huggins|humphr|jackson|jenkin|johnson|juliana|katrine|kellogg|kennedy|kipling|lambert|leacock|leonard|leopold|lincoln|lindsay|longman|macadam|malachi|malthus|margery|marjory|marlowe|matthew|maugham|maurice|maxwell|michael|moulton|needham|nichol|obadiah|o’casey|orlando|patrick|peacock|pearson|pollitt|pullman|quiller|raleign|ramsden|raphael|raymond|rebecca|ricardo|richard|robbins|robeson|russell|saroyan|sassoon|scripps|service|shelley|simpson|smedley|southey|spencer|spender|spenser|stephen|susanna|thodore|theresa|thomson|thoreau|timothy|toynbee|ulysses|vaughan|vincent|walkley|wallace|walpole|webster|wheeler|whitman|willard|william|wilmot|windsor|woolley|wyclif)";
    String NA_8_LOWER = "(adelaide|aldridge|anderson|arabella|augustus|bartlett|beaufort|beerbohm|benedict|benjamin|berkeley|bessemer|brewster|browning|carllyle|carnegie|caroline|cecillia|christie|clarissa|congreve|crichton|cromwell|dorothea|douglas|eipstein|euphemia|eveline|faulkner|ferguson|fielding|franklin|geoffrey|grantham|habakkuk|hamilton|harriman|harrison|jennings|jeremiah|jonathan|kathleen|kingsley|lancelot|lawrence|leighton|macaulay|margaret|marshall|mathilda|mccarthy|mcdonald|melville|meredith|morrison|nehemiah|nicholas|o’connor|patience|philemon|pulitzer|rayleign|reynolds|richards|robinson|rosalind|rossetti|rudolph|sheridan|sherwood|sinclair|smollett|stephens|stilwell|strachey|tennyson|thompson|trollpoe|virginia|wheatley|whittier|winifred|wodehous|zangwill)";
    String NA_9_LOWER = "(ackerman|aldington|alexander|archibald|armstrong|augustine|carpenter|charlotte|christian|churchill|colclough|coleridge|constance|coverdale|dequincey|edgeworth|elizabeth|ferdinand|frederick|galbraith|gallacher|gladstone|goldsmith|hawthorne|hemingway|henrietta|ingersoll|jefferson|johnston|katharine|lattimore|lindberg|macarthur|mansfield|marcellus|masefield|michelson|middleton|nathaniei|partridge|priestley|roosevelt|sainsbury|sailsbury|steinbeck|stevenson|swinburne|thackeray|thorndike|tomlinson|trevelyan|valentine|whitehead|wollaston|zacharias|zechariah|zephaniah|zimmerman)";
    String NA_10_LOWER = "(antoinette|bloomfield|catharine|chesterton|christiana|cumberland|eisenhower|fitzgerald|galsworthy|harrington|huntington|longfellow|macdonald|mackintosh|macmillan|montgomery|richardson|rutherford|springhall|washington|wilhelmina|wordsworth)";
    String NA_11_LOWER = "(bartholomew|burne-jones|chamberlain|christopher|copperfield|macpherson|rockefeller|shakespeare|sonmerfield)";

    String HeatWord_4 = "(.com|.com|0000|0123|1111|1212|1234|1234|1313|1314|1969|1973|1975|1976|1977|1978|1979|1980|1981|1982|1982|1983|1983|1984|1984|1985|1985|1986|1986|1987|1987|1988|1988|1989|1989|1990|1990|1991|1991|1992|1993|1994|1995|1996|1997|1998|2000|2000|2001|2002|2003|2004|2005|2005|2006|2006|2007|2007|2008|2008|2009|2009|2010|2010|2012|2345|3000|3344|4321|4eva|4lyf|6969|8888|Abcd|Alex|Amor|Asdf|Babe|Baby|Baby|Blue|CSDN|Chao|Chen|Cool|Cute|Dong|Ever|Fang|Feng|Fuck|Girl|Gurl|Haha|Hong|Java|Jian|Jing|John|Juan|King|King|LOVE|Life|Ling|Long|Love|Love|Ming|Peng|Ping|Pink|Pogi|Qing|Quan|Rock|Rong|Rose|Ryan|Sexy|Song|Star|Tian|Ting|Xiao|Xing|Yang|Ying|Yong|Yuan|Zhao|Zhou|_123|bear|bebe|best|csdn|e123|fuck|head|jack|jade|jane|jose|lady|luis|mama|paul|rule|s123|wang)";
    String HeatWord_5 = "(12345|4ever|4life|Admin|Apple|Smile|TEAMO|Zhang|angel|bitch|james|jesus|lover|rocks|rules|teamo)";
    String HeatWord_6 = "(100200|112358|123123|123321|159357|159753|456852|666888|753951|789456|951753|abc123|beyond|dragon|hacker|shmily|woaini)";
    String HeatWord_7 = "(1314520|5201314|5211314|7758258|7758521|@qq.com|forever|windows)";
    String HeatWord_8 = "(31415926|88888888|@aol.com|dearbook|iloveyou|password)";
    String HeatWord_9 = "(123456789|987654321)";

    List<HeatStructureRule> HEAT_STRUCTURE_RULES = Arrays.asList(
            //SUPER LOW =================================================================================================================
            new HeatStructureRule(CHINESE_WORD + "+", 10d, "多位中文"),
            new HeatStructureRule(EMAIL, 10d, "邮件格式"),
            new HeatStructureRule(MAC, 10d, "电脑MAC地址"),
            new HeatStructureRule(ID_CARD, 10d, "身份证"),
            new HeatStructureRule(IP, 10d, "IP地址"),
            new HeatStructureRule(DATE, 10d, "日期格式"),
            new HeatStructureRule(TIMER_24, 10d, "24制时间格式"),
            new HeatStructureRule(TIMER_12, 10d, "12制时间格式"),
            new HeatStructureRule(NA_3, Math.pow(10, 7), "3位名字"),
            new HeatStructureRule(NA_4, Math.pow(10, 7), "4位名字"),
            new HeatStructureRule(NA_5, Math.pow(10, 7), "5位名字"),
            new HeatStructureRule(NA_6, Math.pow(10, 7), "6位名字"),
            new HeatStructureRule(NA_7, Math.pow(10, 7), "7位名字"),
            new HeatStructureRule(NA_8, Math.pow(10, 7), "8位名字"),
            new HeatStructureRule(NA_9, Math.pow(10, 7), "9位名字"),
            new HeatStructureRule(NA_10, Math.pow(10, 7), "10位名字"),
            new HeatStructureRule(NA_11, Math.pow(10, 7), "11位名字"),
            new HeatStructureRule(NA_3_LOWER, Math.pow(10, 7), "3位小写名字"),
            new HeatStructureRule(NA_4_LOWER, Math.pow(10, 7), "4位小写名字"),
            new HeatStructureRule(NA_5_LOWER, Math.pow(10, 7), "5位小写名字"),
            new HeatStructureRule(NA_6_LOWER, Math.pow(10, 7), "6位小写名字"),
            new HeatStructureRule(NA_7_LOWER, Math.pow(10, 7), "7位小写名字"),
            new HeatStructureRule(NA_8_LOWER, Math.pow(10, 7), "8位小写名字"),
            new HeatStructureRule(NA_9_LOWER, Math.pow(10, 7), "9位小写名字"),
            new HeatStructureRule(NA_10_LOWER, Math.pow(10, 7), "10位小写名字"),
            new HeatStructureRule(NA_11_LOWER, Math.pow(10, 7), "11位小写名字"),
            new HeatStructureRule(HeatWord_4, Math.pow(10, 7), "4位热词"),
            new HeatStructureRule(HeatWord_5, Math.pow(10, 7), "5位热词"),
            new HeatStructureRule(HeatWord_6, Math.pow(10, 7), "6位热词"),
            new HeatStructureRule(HeatWord_7, Math.pow(10, 7), "7位热词"),
            new HeatStructureRule(HeatWord_8, Math.pow(10, 7), "8位热词"),
            new HeatStructureRule(HeatWord_9, Math.pow(10, 7), "9位热词"),
            /*
            new HeatStructureRule(AZ_LOWER + "{5}" + NUM09 + "{2} ", 2.984 * Math.pow(10, 5), "5位小写字母加2位数字"),
            new HeatStructureRule(AZ_LOWER + "{2}" + NUM09 + "{4}", 6.67 * Math.pow(10, 6), "2位小写字母加4位数字"),
            new HeatStructureRule(AZ_LOWER + "{4}" + NUM09 + "{2} ", 5.62 * Math.pow(10, 5), "4位小写字母加2位数字"),
            new HeatStructureRule(NA_6 + "[0-9]{2}", 3.22 * Math.pow(10, 5), "6位名字加2位数字"),
            new HeatStructureRule(AZ_LOWER + "{6}", 3.09 * Math.pow(10, 8), "6位小写字母"),
            new HeatStructureRule(AZ_LOWER + "{4}" + NUM09 + "{2} ", 4.57 * Math.pow(10, 7), "4位小字母加2位数字"),
            new HeatStructureRule(AZ_LOWER + "{3}" + NUM09 + "{4}", 1.76 * Math.pow(10, 8), "3位字母加4位小写数字"),
            new HeatStructureRule(HeatWord_6 + NUM09 + "{2}", 1.25 * Math.pow(10, 5), "6位热词加2位数字"),
            new HeatStructureRule(TIMER_12 + NUM09 + "{5}", 5.21 * Math.pow(10, 8), "12制时间格式加5位数字"),
            new HeatStructureRule(AZ_HIGH + AZ_VOWEL + AZ_HIGH + AZ_VOWEL, 1.11 * Math.pow(10, 6), "大写字母加元音字母加大写字母加元音字母"),
            new HeatStructureRule(AZ_HIGH + "{2}", 1.11 * Math.pow(10, 6), "2位大写字母"),
            new HeatStructureRule(AZ_VOWEL + AZ_HIGH + AZ_VOWEL, 1.11 * Math.pow(10, 6), "元音字母加大写字母加元音字母"),
            new HeatStructureRule(AZ_HIGH + AZ_VOWEL + AZ_HIGH + AZ_VOWEL + AZ_HIGH, 1.13 * Math.pow(10, 6), "大写字母加元音字母混合2次"),
            new HeatStructureRule(AZ_HIGH + AZ_VOWEL + "{2}", 1.13 * Math.pow(10, 6), "大写字母加2位元音字母"),
            new HeatStructureRule(AZ_HIGH + AZ_LOW, 1.13 * Math.pow(10, 6), "大写字母加小写字母"),
            new HeatStructureRule(AZ_VOWEL + AZ_LOW, 1.13 * Math.pow(10, 6), "元音字母加小写字母"),
            new HeatStructureRule(NUM09 + "{2}", 1.13 * Math.pow(10, 6), "2位数字"),
            new HeatStructureRule(AZ_LOW + AZ_VOWEL + AZ_HIGH, 1.13 * Math.pow(10, 6), "小写字母加元音加大写字母"),*/
            //LOW =====================================================================================================================
            new HeatStructureRule("([\\d])\\1{3}", HeatStructureStandard.LOW, "3位数字"),
            new HeatStructureRule(NA_5 + NUM09 + "{2}", 2.593 * Math.pow(10, 5), "5位名字加2位数字"),
            new HeatStructureRule(HeatWord_4 + NUM09 + "{4}", 5.62 * Math.pow(10, 18), "4位热词加4位数字"),
            new HeatStructureRule(AZ_LOW + "{5}", HeatStructureStandard.LOW, "5位小写字母"),
            new HeatStructureRule(AZ_LOW + "{3}" + NUM09 + "{3}", HeatStructureStandard.LOW, "3位小写字母"),
            new HeatStructureRule(AZ_HIGH + AZ_VOWEL, HeatStructureStandard.LOW, "大写字母加元音字母"),
            new HeatStructureRule(HeatWord_5 + NUM09 + "{3}", 5.213 * Math.pow(10, 7), "5位热词加3位数字"),
            new HeatStructureRule(NUM09 + "{5}", HeatStructureStandard.LOW, "5位数字"),
            new HeatStructureRule(AZ_HIGH + AZ_VOWEL + AZ_HIGH, HeatStructureStandard.LOW, "大写字母加元音字母加大写字母"),
            new HeatStructureRule(AZ_LOW + AZ_VOWEL, HeatStructureStandard.LOW, "小写字母加元音字母"),
            new HeatStructureRule(NUM09 + "{6}", HeatStructureStandard.LOW, "6位数字"),
            new HeatStructureRule(AZ_HIGH + AZ_VOWEL + AZ_HIGH + AZ_VOWEL, HeatStructureStandard.LOW, "大写字母加元音字母混合2词"),
            new HeatStructureRule(AZ_HIGH + "{2}", HeatStructureStandard.LOW, "2位大写字母"),
            new HeatStructureRule(AZ_VOWEL + AZ_HIGH + AZ_VOWEL, HeatStructureStandard.LOW, "元音字母夹杂大写字母"),
            new HeatStructureRule(NA_4 + NUM09 + "{2}", HeatStructureStandard.LOW, "4位姓名加2位数字"),
            new HeatStructureRule(AZ_HIGH + AZ_VOWEL + "{2}", 3.65 * Math.pow(10, 5), "大写字母加2位元音字母"),
            new HeatStructureRule(AZ_HIGH + AZ_LOW, HeatStructureStandard.LOW, "大写字母加小写字母"),
            new HeatStructureRule(HeatWord_8 + AZ_LOW, HeatStructureStandard.LOW, "8位热词加小写字母"),
            new HeatStructureRule(HeatWord_7, HeatStructureStandard.LOW, "7位热词"),
            new HeatStructureRule(AZ_LOW + AZ_VOWEL + AZ_HIGH, HeatStructureStandard.LOW, "小写加元音加大写字母"),
            //MEDIUM===================================================================================================================
            new HeatStructureRule(NUM09 + "{5}", HeatStructureStandard.MEDIUM, "5位数字"),
            new HeatStructureRule(AZ_HIGH + "{4}" + AZ_VOWEL, HeatStructureStandard.MEDIUM, "4位大写字母加元音字母"),
            new HeatStructureRule(NUM09 + AZ_VOWEL + "{4}", HeatStructureStandard.MEDIUM, "数字加4位元音字母"),
            new HeatStructureRule(NUM09 + AZ_LOW + "{4}", HeatStructureStandard.MEDIUM, "数字加4位小写字母"),
            new HeatStructureRule(AZ_HIGH + "{3}" + AZ_VOWEL + AZ_HIGH, HeatStructureStandard.MEDIUM, "3位大写字母加元音字母加大写字母"),
            new HeatStructureRule(AZ_LOW + AZ_VOWEL + "{4}", HeatStructureStandard.MEDIUM, "小写字母加4位元音字母"),
            new HeatStructureRule(NUM09 + "{6}", HeatStructureStandard.MEDIUM, "6位数字"),
            new HeatStructureRule(AZ_HIGH + AZ_VOWEL + AZ_HIGH + "{3}" + AZ_VOWEL, HeatStructureStandard.MEDIUM, "大写字母夹杂元音字母"),
            new HeatStructureRule(NUM09 + AZ_HIGH + "{4}", HeatStructureStandard.MEDIUM, "数字加4位大写字母"),
            new HeatStructureRule(AZ_VOWEL + AZ_HIGH + AZ_VOWEL + "{3}", HeatStructureStandard.MEDIUM, "元音字母夹杂大写字母"),
            new HeatStructureRule(AZ_HIGH + AZ_VOWEL + AZ_HIGH + AZ_VOWEL + AZ_HIGH, HeatStructureStandard.MEDIUM, "元音字母夹杂大写字母"),
            new HeatStructureRule(AZ_HIGH + "{3}" + AZ_VOWEL + "{2}", HeatStructureStandard.MEDIUM, "3位大写字母加2位元音字母"),
            new HeatStructureRule(AZ_HIGH + AZ_LOW + NUM09 + "{3}", HeatStructureStandard.MEDIUM, "大写字母加小写字母加3位数字"),
            new HeatStructureRule(AZ_VOWEL + "{3}" + AZ_LOW + NUM09, HeatStructureStandard.MEDIUM, "3位何原因字母加小写字母加数字"),
            new HeatStructureRule(NUM09 + "{2}" + AZ_VOWEL + "{3}", HeatStructureStandard.MEDIUM, "2位数字加3位元音字母"),
            new HeatStructureRule(AZ_LOW + AZ_VOWEL + "{3}" + AZ_HIGH, HeatStructureStandard.MEDIUM, "小写字母加3位元音字母加大写字母"),
            //HIGH======================================================================================================================
            new HeatStructureRule(NUM09 + "{4}" + SP + "{3}", HeatStructureStandard.HIGH, "4位数字"),
            new HeatStructureRule(AZ_HIGH + AZ_VOWEL + "{3}" + SP + "{3}", HeatStructureStandard.HIGH, "大写字母加3位元音字母加3位特殊字母"),
            new HeatStructureRule(NUM09 + "{2}" + SP + "{5}", HeatStructureStandard.HIGH, "2位数字加5位特殊字符"),
            new HeatStructureRule(NUM09 + "{5}" + SP + "{2}", HeatStructureStandard.HIGH, "5位数字加2位特殊字符"),
            new HeatStructureRule(AZ_HIGH + AZ_VOWEL + AZ_HIGH + SP + "{4}", HeatStructureStandard.HIGH, "大写字母夹杂元音加4位特殊字符"),
            new HeatStructureRule(AZ_LOW + AZ_VOWEL + SP + "{5}", HeatStructureStandard.HIGH, "小写字母加元音加5位特殊字符"),
            new HeatStructureRule(NUM09 + "{6}" + SP + "{1}", HeatStructureStandard.HIGH, "6位数字加1位特殊字符"),
            new HeatStructureRule(AZ_HIGH + AZ_VOWEL + AZ_HIGH + AZ_VOWEL + SP + "{3}", HeatStructureStandard.HIGH, "大写字母加元音字母加3位特殊字符"),
            new HeatStructureRule(AZ_HIGH + "{2}" + SP + "{5}", HeatStructureStandard.HIGH, "2位大写字母加5位特殊字符"),
            new HeatStructureRule(AZ_VOWEL + AZ_HIGH + AZ_VOWEL + SP + "{4}", HeatStructureStandard.HIGH, "元音字母夹杂大写字母加4位特殊字符"),
            new HeatStructureRule(AZ_HIGH + AZ_VOWEL + AZ_HIGH + SP + "{2}" + AZ_VOWEL + AZ_HIGH, HeatStructureStandard.HIGH, "大写字母夹杂元音字母加2位特殊字符"),
            new HeatStructureRule(AZ_HIGH + AZ_VOWEL + "{2}" + SP + "{4}", HeatStructureStandard.HIGH, "大写字母加2位元音字母加4位特殊字符"),
            new HeatStructureRule(AZ_HIGH + AZ_LOW + SP + "{5}", HeatStructureStandard.HIGH, "大写字母加小写字母加5位特殊字符"),
            new HeatStructureRule(AZ_VOWEL + AZ_LOW + SP + "{5}", HeatStructureStandard.HIGH, "元音字母加小写字母加5位特殊字符"),
            new HeatStructureRule(SP + "{2}" + NUM09 + "{2}" + SP + "{2}" + AZ_VOWEL, HeatStructureStandard.HIGH, "2位特殊字符夹杂2位数字加元音字母"),
            new HeatStructureRule(AZ_LOW + SP + "{2}" + AZ_VOWEL + AZ_HIGH + SP + "{2}", HeatStructureStandard.HIGH, "小写字母加特殊字符加大写字母混杂"),
            //SUPER HIGH==================================================================================================================
            new HeatStructureRule("^(?![0-9]+$)(?![a-zA-Z]+$)[0-9A-Za-z._!\\-\\*@#/$,+&\\)=?(';]%<~[:^`\">{}|]{8,}$", HeatStructureStandard.SUPER_HIGH, "8位以上字母加数字加特殊字符混合而成")
    );
}
