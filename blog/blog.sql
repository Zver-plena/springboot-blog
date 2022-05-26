/*
 Navicat Premium Data Transfer

 Source Server         : myConnection
 Source Server Type    : MySQL
 Source Server Version : 80029
 Source Host           : localhost:3306
 Source Schema         : blogdemo2

 Target Server Type    : MySQL
 Target Server Version : 80029
 File Encoding         : 65001

 Date: 20/05/2022 20:04:12
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;
drop database if exists blog;
create database blog;
use blog;
-- ----------------------------
-- Table structure for categories
-- ----------------------------
DROP TABLE IF EXISTS `categories`;
CREATE TABLE `categories` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `count` int DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb3;

-- ----------------------------
-- Records of categories
-- ----------------------------
BEGIN;
INSERT INTO `categories` (`id`, `name`, `count`) VALUES (1, '笔记', 2);
INSERT INTO `categories` (`id`, `name`, `count`) VALUES (2, 'Java', 0);
INSERT INTO `categories` (`id`, `name`, `count`) VALUES (4, '学习笔记', 2);
COMMIT;

-- ----------------------------
-- Table structure for page
-- ----------------------------
DROP TABLE IF EXISTS `page`;
CREATE TABLE `page` (
  `id` int NOT NULL AUTO_INCREMENT,
  `userId` int DEFAULT NULL,
  `title` varchar(100) CHARACTER SET utf8mb3 COLLATE utf8_general_ci DEFAULT NULL,
  `content` text CHARACTER SET utf8mb3 COLLATE utf8_general_ci,
  `createTime` varchar(50) CHARACTER SET utf8mb3 COLLATE utf8_general_ci DEFAULT NULL,
  `category` int DEFAULT NULL,
  `view` int DEFAULT NULL,
  `summary` text CHARACTER SET utf8mb3 COLLATE utf8_general_ci,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb3;

-- ----------------------------
-- Records of page
-- ----------------------------
BEGIN;
INSERT INTO `page` (`id`, `userId`, `title`, `content`, `createTime`, `category`, `view`, `summary`) VALUES (1, 1, 'Linux学习记录', '## LINUX虚拟机\r\n\r\n```shell\r\nsystemctl set-default multi-user.target  \"默认进入字符界面\"\r\nsystemctl set-default graphical.target   \"默认进入图形界面\"\r\n\r\ninit 5\r\n\r\nCTRL+ALT+F1-F6\r\n\r\n\r\n```\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n## TMUX\r\n\r\n```shell\r\n功能：\r\n    (1) 分屏。\r\n    (2) 允许断开Terminal连接后，继续运行进程。\r\n结构：\r\n    一个tmux可以包含多个session，一个session可以包含多个window，一个window可以包含多个pane。\r\n    实例：\r\n        tmux:\r\n            session 0:\r\n                window 0:\r\n                    pane 0\r\n                    pane 1\r\n                    pane 2\r\n                    ...\r\n                window 1\r\n                window 2\r\n                ...\r\n            session 1\r\n            session 2\r\n            ...\r\n操作：\r\n    (1) tmux：新建一个session，其中包含一个window，window中包含一个pane，pane里打开了一个shell对话框。\r\n   	新建窗口Ctrl + a后手指松开，然后按c:创建一个新的窗口\r\n    (2) 按下Ctrl + a后手指松开，然后按%：将当前pane左右平分成两个pane。\r\n    (3) 按下Ctrl + a后手指松开，然后按\"（注意是双引号\"）：将当前pane上下平分成两个pane。\r\n    (4) Ctrl + d：关闭当前pane；如果当前window的所有pane均已关闭，则自动关闭window；如果当前session的所有window均已关闭，则自动关闭session。\r\n    (5) 鼠标点击可以选pane。\r\n    (6) 按下ctrl + a后手指松开，然后按方向键：选择相邻的pane。\r\n    (7) 鼠标拖动pane之间的分割线，可以调整分割线的位置。\r\n    (8) 按住ctrl + a的同时按方向键，可以调整pane之间分割线的位置。\r\n    (9) 按下ctrl + a后手指松开，然后按z：将当前pane全屏/取消全屏。\r\n#    (10) 按下ctrl + a后手指松开，然后按d：挂起当前session。\r\n    (11) tmux a：打开之前挂起的session。\r\n    (12) 按下ctrl + a后手指松开，然后按s：选择其它session。\r\n        方向键 —— 上：选择上一项 session/window/pane\r\n        方向键 —— 下：选择下一项 session/window/pane\r\n        方向键 —— 右：展开当前项 session/window\r\n        方向键 —— 左：闭合当前项 session/window\r\n    (13) 按下Ctrl + a后手指松开，然后按c：在当前session中创建一个新的window。\r\n    (14) 按下Ctrl + a后手指松开，然后按w：选择其他window，操作方法与(12)完全相同。\r\n    (15) 按下Ctrl + a后手指松开，然后按PageUp：翻阅当前pane内的内容。\r\n    (16) 鼠标滚轮：翻阅当前pane内的内容。\r\n    (17) 在tmux中选中文本时，需要按住shift键。（仅支持Windows和Linux，不支持Mac，不过该操作并不是必须的，因此影响不大）\r\n    (18) tmux中复制/粘贴文本的通用方式：\r\n        (1) 按下Ctrl + a后松开手指，然后按[\r\n        (2) 用鼠标选中文本，被选中的文本会被自动复制到tmux的剪贴板\r\n        (3) 按下Ctrl + a后松开手指，然后按]，会将剪贴板中的内容粘贴到光标处\r\n命令:\r\n\r\ntmux new　　创建默认名称的会话（在tmux命令模式使用new命令可实现同样的功能，其他命令同理，后文不再列出tmux终端命令）\r\n\r\ntmux new -s mysession　　创建名为mysession的会话\r\n\r\ntmux ls　　显示会话列表\r\n\r\ntmux a　　连接上一个会话\r\n\r\ntmux a -t mysession　　连接指定会话\r\n\r\ntmux rename -t s1 s2　　重命名会话s1为s2\r\n\r\ntmux kill-session　　关闭上次打开的会话\r\n\r\ntmux kill-session -t s1　　关闭会话s1\r\n\r\ntmux kill-session -a -t s1　　关闭除s1外的所有会话\r\n\r\ntmux kill-server　　关闭所有会话\r\n\r\ntmux kill-window -t s1 ： 关闭会话s1的一个窗口\r\n\r\n\r\n```\r\n\r\n\r\n\r\n## VIM\r\n\r\n\r\n\r\n```shell\r\n功能：\r\n    (1) 命令行模式下的文本编辑器。\r\n    (2) 根据文件扩展名自动判别编程语言。支持代码缩进、代码高亮等功能。\r\n    (3) 使用方式：vim filename\r\n        如果已有该文件，则打开它。\r\n        如果没有该文件，则打开个一个新的文件，并命名为filename\r\n    \r\n操作：\r\n    (1) i：进入编辑模式\r\n    (2) ESC：进入一般命令模式\r\n    (3) h 或 左箭头键：光标向左移动一个字符\r\n    (4) j 或 向下箭头：光标向下移动一个字符\r\n    (5) k 或 向上箭头：光标向上移动一个字符\r\n    (6) l 或 向右箭头：光标向右移动一个字符\r\n    (7) n<Space>：n表示数字，按下数字后再按空格，光标会向右移动这一行的n个字符\r\n    (8) 0 或 功能键[Home]：光标移动到本行开头\r\n    (9) $ 或 功能键[End]：光标移动到本行末尾\r\n    (10) G：光标移动到最后一行\r\n    (11) :n 或 nG：n为数字，光标移动到第n行\r\n    (12) gg：光标移动到第一行，相当于1G\r\n    (13) n<Enter>：n为数字，光标向下移动n行\r\n    (14) /word：向光标之下寻找第一个值为word的字符串。\r\n    (15) ?word：向光标之上寻找第一个值为word的字符串。\r\n    (16) n：重复前一个查找操作\r\n    (17) N：反向重复前一个查找操作\r\n    (18) :n1,n2s/word1/word2/g：n1与n2为数字，在第n1行与n2行之间寻找word1这个字符串，并将该字符串替换为word2\r\n    (19) :1,$s/word1/word2/g：将全文的word1替换为word2\r\n    (20) :1,$s/word1/word2/gc：将全文的word1替换为word2，且在替换前要求用户确认。\r\n    (21) v：选中文本\r\n    (22) d：删除选中的文本\r\n    (23) dd: 删除当前行\r\n    (24) y：复制选中的文本\r\n    (25) yy: 复制当前行\r\n    (26) p: 将复制的数据在光标的下一行/下一个位置粘贴\r\n    (27) u：撤销\r\n    (28) Ctrl + r：取消撤销\r\n    (29) 大于号 >：将选中的文本整体向右缩进一次\r\n    (30) 小于号 <：将选中的文本整体向左缩进一次\r\n    (31) :w 保存\r\n    (32) :w! 强制保存\r\n    (33) :q 退出\r\n    (34) :q! 强制退出\r\n    (35) :wq 保存并退出\r\n    (36) :set paste 设置成粘贴模式，取消代码自动缩进\r\n    (37) :set nopaste 取消粘贴模式，开启代码自动缩进\r\n    (38) :set nu 显示行号\r\n    (39) :set nonu 隐藏行号\r\n    (40) gg=G：将全文代码格式化\r\n#    (41) :noh 关闭查找关键词高亮\r\n    (42) Ctrl + q：当vim卡死时，可以取消当前正在执行的命令\r\n异常处理：\r\n    每次用vim编辑文件时，会自动创建一个.filename.swp的临时文件。\r\n    如果打开某个文件时，该文件的swp文件已存在，则会报错。此时解决办法有两种：\r\n        (1) 找到正在打开该文件的程序，并退出\r\n        (2) 直接删掉该swp文件即可\r\n\r\n```\r\n\r\n\r\n\r\n\r\n\r\n## Shell\r\n\r\n### 变量\r\n\r\n使用变量，需要加上$符号，或者${}符号。花括号是可选的，主要为了帮助解释器识别变量边界。\r\n\r\n```shell\r\n# 注意等号两边不要有空格\r\nname=hello\r\nname=\'hello\'\r\nname=\"hello\"\r\n#删除变量 unset\r\nunset name\r\n# 使用变量的值\r\necho ${hello}\r\n\r\n```\r\n\r\n#### 单引号和双引号的区别\r\n\r\n字符串可以用单引号，也可以用双引号，也可以不用引号。\r\n\r\n单引号与双引号的区别：\r\n\r\n- 单引号中的内容会原样输出，不会执行、不会取变量；\r\n\r\n- 双引号中的内容可以执行、可以取变量；\r\n\r\n```shell\r\nname=xxx  # 不用引号\r\n\r\necho \'hi, $name \\\"hh\\\"\'  \r\n# 单引号字符串，输出 hi, $name \\\"hh\\\"\r\n\r\necho \"hi, $name \\\"hh\\\"\" \r\n# 双引号字符串，输出 hi, xxx \"hh\"\r\n```\r\n\r\n### 判断语句\r\n\r\n- 表达式的exit code为0，表示真；为非零，表示假\r\n- **test  或 [ ]** \r\n- 条件表达式要放在方括号之间，并且要有空格，例如: **[$a==$b]** 是错误的，必须写成 **[ $a == $b ]**。\r\n\r\n#### 判断文件类型\r\n\r\n| 参数 |     意义     |\r\n| :--: | :----------: |\r\n|  -e  | 文件是否存在 |\r\n|  -f  |  是否为文件  |\r\n|  -d  |  是否为目录  |\r\n\r\n\r\n\r\n```shell\r\n#  判断文件夹是否存在\r\nif [ ! -d \"/data/\" ];then\r\n  echo \"文件夹不存在\"\r\nelse\r\n  echo \"文件夹已经存在\"\r\nfi\r\n# 判断文件是否存在\r\nif [ ! -f \"/data/filename\" ];then\r\n  echo \"文件不存在\"\r\nelse\r\n  echo \"文件存在\"\r\nfi\r\n# \r\n```\r\n\r\n\r\n\r\n#### 判断文件权限\r\n\r\n| 参数 |     意义     |\r\n| :--: | :----------: |\r\n|  -r  |   可读权限   |\r\n|  -w  |   可写权限   |\r\n|  -x  |   执行权限   |\r\n|  -s  | 文件是否为空 |\r\n\r\n#### 判断数字\r\n\r\n| 参数 | 意义 |\r\n| :--: | :--: |\r\n| -eq  | a==b |\r\n| -ne  | a!=b |\r\n| -gt  | a>b  |\r\n| -lt  | a<b  |\r\n| -ge  | a>=b |\r\n| -le  | a<=b |\r\n\r\n#### 判断字符串\r\n\r\n| 参数 |            意义            |\r\n| :--: | :------------------------: |\r\n|  -z  | 判断为空，如果为空返回True |\r\n|  -n  | 判断非空，如果非空返回True |\r\n\r\n#### 判断内部的逻辑符\r\n\r\n| 参数 |                        意义                         |\r\n| :--: | :-------------------------------------------------: |\r\n|  -a  |               两条件是否同时成立(&&)                |\r\n|  -o  |            两条件是否至少一个成立 (\\|\\|)            |\r\n|  !   | 取反。如 test ! -x file，当file不可执行时，返回true |\r\n\r\n\r\n\r\n#### test\r\n\r\n- 在命令行中输入`man test`，可以查看test命令的用法。\r\n\r\n- `test`命令用于判断文件类型，以及对变量做比较。\r\n\r\n- `test`命令用exit code返回结果，而不是使用stdout。0表示真，非0表示假。\r\n\r\n##### 例子\r\n\r\n```shell\r\ntest 2 -lt 3  # 为真，返回值为0\r\necho $?  # 输出上个命令的返回值，输出0\r\n```\r\n\r\n#### [] 判断符\r\n\r\n##### 例子\r\n\r\n```bash\r\n[ 2 -lt 3 ]  # 为真，返回值为0\r\necho $?  # 输出上个命令的返回值，输出0\r\n```\r\n\r\n\r\n\r\n### 代码实例\r\n\r\n#### 移动图片\r\n\r\n```shell\r\n#! /bin/bash\r\n\r\n\r\nFROM_PATH=/Users/mrl/Downloads/\r\nTO_PATH=/Users/mrl/Pictures\r\n# 获取文件后缀 ${1##*.} // ## 任意多个左边，  *.	：删除.左边的字符\r\n# 获取文件前缀 ${1%%.*} // %% 任意多个右边，  *.	：删除.右边的字符\r\n\r\nfor file in `ls $FROM_PATH`\r\ndo\r\n    echo \"${file##.}\" # 获取文件的后缀\r\n    if [ \"${file##*.}\" == \"png\" ] || [ \"${file##*.}\" == \"jpg\" ] || [ \"${file##*.}\" == \"jpeg\" ];then\r\n\r\n        mv ${FROM_PATH}${file} ${TO_PATH}\r\n    fi\r\n\r\ndone\r\n\r\n```\r\n\r\n#### 文件名字后缀前缀提取\r\n\r\n```shell\r\n#文件名字\r\nfile=/dir1/dir2/dir3/my.file.txt\r\n\r\n${file#*/}：删掉第一个 / 及其左边的字符串：dir1/dir2/dir3/my.file.txt\r\n${file##*/}：删掉最后一个 /  及其左边的字符串：my.file.txt\r\n${file#*.}：删掉第一个 .  及其左边的字符串：file.txt\r\n${file##*.}：删掉最后一个 .  及其左边的字符串：txt\r\n${file%/*}：删掉最后一个  /  及其右边的字符串：/dir1/dir2/dir3\r\n${file%%/*}：删掉第一个 /  及其右边的字符串：(空值)\r\n${file%.*}：删掉最后一个  .  及其右边的字符串：/dir1/dir2/dir3/my.file\r\n${file%%.*}：删掉第一个  .   及其右边的字符串：/dir1/dir2/dir3/my\r\n\r\n\'#\'   是去掉左边（键盘上#在 $ 的左边）\r\n\'%\'   是去掉右边（键盘上% 在$ 的右边）\r\n单一符号是最小匹配；两个符号是最大匹配\r\n\r\n       :index:len\r\n${file:0:5}：提取位置0开始的5 个字节：/dir1\r\n${file:5:5}：提取位置5开始的5个字节：/dir2\r\n\r\n\r\n```\r\n\r\n\r\n\r\n#### 监听内存定时任务\r\n\r\n```shell\r\n#/bin/bash\r\n#free-m查询内存\r\n#|awk管道\r\n#NR=2第二行\r\n#NF最后一列\r\n# 信息保存到FREEMEN\r\nFREEMEM=free -m |awk \'NR==2 {print $NF}\' CHARS=\"Current memory is $FREEMEN\"\r\nif $FREEMEN -lt \"100\"];then\r\n\r\n	#打印日志到对应的文件\r\n	echo $CHARS tee /home/lgx/script/messages.txt \r\n	\r\n	#mail发送邮箱 标题               邮箱                   内容\r\n	mail -s \"data +%F-%T $CHARS  144@gq.com < /home/lgx/scrpt/massages.txt\r\n	\r\n	echo \"内存不足\"\r\nfi\r\n#之后使用crontab-l添加定时任务\r\n#对应的时间的文件夹下添加对应的sh文件\r\n#例如 使用crontab -e\r\n```\r\n\r\n\r\n\r\n\r\n\r\n### echo命令\r\n\r\n[连接](https://www.runoob.com/linux/linux-shell-echo.html)\r\n\r\n#### 转义字符\r\n\r\n```shell\r\n\r\necho -e \"OK! \\c\" # -e 开启转义 \\c 不换行\r\necho \"It is a test\"\r\n\r\necho -e \"OK! \\n\" # -e 开启转义\r\n```\r\n\r\n#### 结果重定向\r\n\r\n```shell\r\necho \"It is a test\" > myfile # 覆写\r\necho \"I know \" >> myfile #追加内容到文件后面\r\n```\r\n\r\n\r\n\r\n### shell 输入/输出重定向\r\n\r\n[Shell 输入/输出重定向](https://www.runoob.com/linux/linux-shell-io-redirections.html)\r\n\r\n\r\n| command > file  | 输出重定向到file |\r\n| --------------- | ---------------- |\r\n| command < file  | 输入重定向到file |\r\n| command >> file | 输出追加到file   |\r\n|                 |                  |\r\n|                 |                  |\r\n|                 |                  |\r\n\r\n## linux命令\r\n\r\n### 查看文件\r\n\r\n```shell\r\n# 判断文件类型\r\nfile a.txt\r\n\r\n# 查看整个文件\r\ncat [] a.txt\r\n\r\n参数\r\n-n:给所有行加行号\r\n-b:只给有内容的行加行号\r\n-T:用^T替换制表符\r\n\r\n```\r\n\r\n#### 查看文件的字数，行数，字节数\r\n\r\n```shell\r\nwc [选项] [文件] \r\n\r\n-c # 统计字节数，或--bytes或——chars：只显示Bytes数；。\r\n-l # 统计行数，或——lines：只显示列数；。\r\n-m # 统计字符数。这个标志不能与 -c 标志一起使用。\r\n-w # 统计字数，或——words：只显示字数。一个字被定义为由空白、跳格或换行字符分隔的字符串。\r\n-L # 打印最长行的长度。\r\n\r\nwc test.txt #行数	字数	字节数 文件名\r\n\r\n\r\n只显示文件的行数\r\n	cat test.txt | wc -l\r\n	wc -l \r\n```\r\n\r\n\r\n\r\n### 键盘读取，数组与声明\r\n\r\n#### read命令\r\n\r\nzsh和bash的区别\r\n\r\n```shell\r\n# 参数\r\n# -p 提示信息\r\n# -t 倒计时\r\n# zsh和bash的区别\r\n\r\n#bash\r\nread -p \"please input : \" -t 30 name\r\n\r\n#zsh\r\nread -t 30 \"name?please input : \" \r\n#提示信息在？后面 -t 在前面\r\n\r\n\r\n\r\n\r\n\r\n```\r\n\r\n#### declare命令\r\n\r\n```shell\r\n#申明变量类型\r\n#参数\r\n# -a ：array类型\r\n# -i : int类型\r\n# -x : 同expor，环境变量\r\n# -r : readonly类型\r\n#\r\n\r\nmrl@MrdeMacBook-Pro ~ % sum=199+29\r\nmrl@MrdeMacBook-Pro ~ % echo ${sum}\r\n199+29\r\nmrl@MrdeMacBook-Pro ~ % declare -i sum=199+20\r\nmrl@MrdeMacBook-Pro ~ % echo ${sum}\r\n219\r\n```\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n### 文件管理\r\n\r\n#### cp命令\r\n\r\n```shell\r\ncp [options] from to\r\n# 参数\r\n-a	：通常在复制目录时候使用，保留文件属性，链接，复制目录下所有内容\r\n-d	：保留链接，链接指windows的快捷方式\r\n-f	：强制覆盖\r\n-i	：询问覆盖\r\n-p	：复制文件的修改时间和访问权限\r\n-r	：如果是一个目录，递归复制目录下所有文件\r\n-l	：不复制文件，只是生成链接文件\r\n```\r\n\r\n#### mv命令\r\n\r\n```bash\r\nmv [option] from to\r\n#mv参数\r\n-f : (force)强制覆盖目标路径，没有询问\r\n-i : (inquire)询问是否操作\r\n-n : ()不会覆盖目标路径\r\n-v : (view)转移后显示文件\r\n```\r\n\r\n### 监测程序\r\n\r\n#### 查看进程（ps）\r\n\r\n```shell\r\n# ps命令\r\n\r\n```\r\n\r\n#### 信息的查看\r\n\r\n- UID（user id）\r\n- PID（process id)\r\n- PPI（parent process id）\r\n- C（CPU）：CPU利用率\r\n- STIME（Start time）：进程启动时的系统时间\r\n- TTY（Teletype）：终端设备\r\n- TIME（time）：运行进程累计CPU时间\r\n- CMD（command）：程序名称\r\n- `VIRT`（virtual memory usage）:虚拟内存\r\n\r\n- `RES`（resident memory usage）：常驻内存\r\n- `SHR`（shared memory）：共享黑村\r\n\r\n#### 实时监测进程（top命令）\r\n\r\n**参数**\r\n\r\n- -d 秒数：指定 top 命令每隔几秒更新。默认是 3 秒；\r\n- -b：使用批处理模式输出。一般和\"-n\"选项合用，用于把 top 命令重定向到文件中；\r\n- -n 次数：指定 top 命令执行的次数。一般和\"-\"选项合用；\r\n- -pid: 进程PID：仅查看指定 ID 的进程；\r\n- -s：使 top 命令在安全模式中运行，避免在交互模式中出现错误；\r\n- -u 用户名：只监听某个用户的进程；\r\n\r\n**在 top 命令的显示窗口中，还可以使用如下按键，进行一下交互操作：**\r\n\r\n- ? 或 h：显示交互模式的帮助；\r\n- P：按照 CPU 的使用率排序，默认就是此选项；\r\n- M：按照内存的使用率排序；\r\n- N：按照 PID 排序；\r\n- T：按照 CPU 的累积运算时间排序，也就是按照 TIME+ 项排序；\r\n- k：按照 PID 给予某个进程一个信号。一般用于中止某个进程，信号 9 是强制中止的信号；\r\n- r：按照 PID 给某个进程重设优先级（Nice）值；\r\n- q：退出 top 命令；\r\n\r\n\r\n\r\n#### 结束进程\r\n\r\n### 监测磁盘空间\r\n\r\n#### 挂载存储媒体\r\n\r\n```shell\r\n# mount 命令 mounting(挂载）\r\n\r\n# unmount 命令\r\n```\r\n\r\n#### 显示挂载设备剩余磁盘空间\r\n\r\n```shell\r\n# df 命令 （disk free）\r\n```\r\n\r\n#### 显示文件，目录的磁盘使用情况\r\n\r\n```shell\r\n# du 命令 (disk usage)\r\ndu -chs ~/blog\r\n\r\n-c：显示所有列出文件总的大小（count）\r\n-h：按照人类易读格式输出，K代替千字节，M代替兆字节，G代替吉字节，(human)\r\n-s: 显示每个输出参数的总计（sum）\r\n```', '2022-05-23 13:00:22', 4, 5, '## LINUX虚拟机\r\n\r\n```shell\r\nsystemctl set-default multi-user.target  \"默认进入字符界面\"\r\nsystemctl set-default ');
INSERT INTO `page` (`id`, `userId`, `title`, `content`, `createTime`, `category`, `view`, `summary`) VALUES (4, 2, '小白菜的第一篇笔记', '### 这个世界他来了', '2022-05-20 01:11:48', 1, 4, '### 这个世界他来了');
INSERT INTO `page` (`id`, `userId`, `title`, `content`, `createTime`, `category`, `view`, `summary`) VALUES (5, 1, '这是我的第二篇博客', '### luck', '2022-05-20 01:16:36', 4, 1, '### luck');
INSERT INTO `page` (`id`, `userId`, `title`, `content`, `createTime`, `category`, `view`, `summary`) VALUES (7, 1, '测试summary', '## 计算机系统概论\r\n\r\n### 计算机发展与应用\r\n\r\n#### 摩尔\r\n\r\n1965年，英特尔公司创始人之一戈登·摩尔提出摩尔定律：集成电路上可容纳的晶体管数量每18个月翻一番，性能提高一倍，价格降低一半。表现在\r\n\r\n- 单个芯片集成度提高后，成本变化不大，因此总体成本总体下降\r\n- 高度集成的芯片中，电路间的距离更近，工作速度跟高\r\n- 增加了芯片内部的连接，从而减少了外部连线，可靠性提高\r\n- 计算机变得更小，减少了电能消耗，适应性更好\r\n\r\n#### 多核处理器\r\n\r\n##### 何为多核技术\r\n\r\n多核技术是通过在一个芯片上集成多个简单的处理器以充分利用这些晶体管资源，以发挥其最大能效\r\n\r\n##### 多核技术的优点\r\n\r\n\r\n\r\n### 计算机系统的组成\r\n\r\n#### 冯·诺伊曼体系\r\n\r\n20世纪40年代，美国科学家（John von Neumann）\r\n\r\n- 存储程序和程序控制是冯诺依曼型计算机的**主要设计思想**\r\n\r\n根据冯·诺依曼的设计思想，计算机的硬件系统应该包含如下\r\n\r\n##### 运算器\r\n\r\n- 运算器是一种用于信息加工的部件，对数据进行算术运算和逻辑运算\r\n- 运算器通常由**算术逻辑部件（ALU）**和**一系列寄存器**组成\r\n- 运算器一次运算处理的二进制位数称为**字长** \r\n\r\n##### 控制器\r\n\r\n- 控制器是全机的指挥中心，使计算机各部件协调工作\r\n- **控制器工作的实质就是解释程序**\r\n- 计算机由两股信息在流动\r\n	- 一股是**控制信息**，即操作命令，分散流向各个部件\r\n	- 一股是**数据信息**，受控制信息控制，从一个部件流向另一个部件\r\n\r\n##### 存储器（主存储器）\r\n\r\n- **存储器的主要功能**：存放程序和数据\r\n\r\n##### 输入设备\r\n\r\n- **输入设备**是将信息输入到计算机的外部设备\r\n\r\n##### 输出设备\r\n\r\n- **输出设备**是将计算机运算结果转换成人们能够接收和识别的设备\r\n\r\n**其中运算器和控制器合称为中央处理器（Central Processing Unit）**\r\n\r\n#### 计算机硬件系统\r\n\r\n- **计算机硬件系统（Hardware System）**是指构成计算机系统的电子线路和电子元件等物理设备的总称\r\n	- 硬件是构成计算机的物质基础，是计算机系统的核心\r\n\r\n#### 计算机软件系统\r\n\r\n**计算机的软件**是将解决问题的方法，思想和过程用程序进行描述，因此程序是软件的核心组成部分\r\n\r\n- 一台计算机全部程序的集合，统称为这台**计算机的软件系统**\r\n\r\n##### 系统软件\r\n\r\n系统软件是用于对计算机系统的管理调度，监视和服务等功能目的是为了方便用户，提高计算机使用效率，扩充系统功能\r\n\r\n- **操作系统**\r\n	- 操作系统是管理计算机各种资源，调度用户作业，处理各种中断的软件\r\n	- 操作系统管理的资源，通常由硬件，软件和数据信息。\r\n- **语言处理程序**\r\n	- 计算机识别的语言，它们都各自规定了一套基本符号和语法规则，用这些语言编制的程序叫做**源程序**\r\n	- 用**0**或**1**的机器代码按照一定的规则组成的语言，称为**机器语言**\r\n	- 用**机器语言**编制的程序，称为**目标程序**\r\n	- 语言处理程序的作用就是把**源程序**翻译成**目标程序**\r\n- **标准程序库**\r\n	- 为方便用户，通常将一些常用的程序段按照标准的格式事先编制好，组成一个标准程序库，使得用户可以直接调用\r\n	- 封装函数\r\n- **服务性程序**\r\n	- 服务性程序，提过多种计算机系统运行所需的服务功能，是一种辅助计算机工作的程序\r\n	- 例如程序的装入，连接，编辑，诊断故障程序，纠错程序，监督程序\r\n- **数据库管理系统（Database Management System DBMS）**\r\n	- DBMS用来管理系统中的所有文件，实现数据共享\r\n- **计算机网络软件**\r\n	- 计算机网络软件是为计算机网络配置的系统软件\r\n\r\n##### 应用软件\r\n\r\n**应用软件**是用户为解决某个应用问题而编制的一些程序', '2022-05-20 16:51:56', 1, 0, '## 计算机系统概论\r\n\r\n### 计算机发展与应用\r\n\r\n#### 摩尔\r\n\r\n1965年，英特尔公司创始人之一戈登·摩尔提出摩尔定律：集成电路上可容纳的晶体管数量每18个月翻一番，性能提高一倍，价');
INSERT INTO `page` (`id`, `userId`, `title`, `content`, `createTime`, `category`, `view`, `summary`) VALUES (8, 1, '哈哈哈', '### 我们今天活动啦', '2022-05-20 19:48:32', 1, 0, '### 我们今天活动啦');
COMMIT;

-- ----------------------------
-- Table structure for page_tag
-- ----------------------------
DROP TABLE IF EXISTS `page_tag`;
CREATE TABLE `page_tag` (
  `tagId` int DEFAULT NULL,
  `pageId` int DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;

-- ----------------------------
-- Records of page_tag
-- ----------------------------
BEGIN;
INSERT INTO `page_tag` (`tagId`, `pageId`) VALUES (1, 1);
COMMIT;

-- ----------------------------
-- Table structure for tags
-- ----------------------------
DROP TABLE IF EXISTS `tags`;
CREATE TABLE `tags` (
  `id` int DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `count` int DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;

-- ----------------------------
-- Records of tags
-- ----------------------------
BEGIN;
INSERT INTO `tags` (`id`, `name`, `count`) VALUES (1, '笔记', 1);
COMMIT;

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8_general_ci DEFAULT NULL,
  `password` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8_general_ci DEFAULT NULL,
  `email` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8_general_ci DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb3;

-- ----------------------------
-- Records of user
-- ----------------------------
BEGIN;
INSERT INTO `user` (`id`, `name`, `password`, `email`) VALUES (1, 'admin', 'Ll1442828431', '1442828431@qq.com');
INSERT INTO `user` (`id`, `name`, `password`, `email`) VALUES (2, 'xiaobaicai', 'xiaobaicai', '1442828413@qq.com');
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;
