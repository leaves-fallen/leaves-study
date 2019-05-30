# Linux 学习笔记

记录学习 Linux 的笔记



# 各硬件设备在 Linux 中的文件名

Linux 系统中 每个设备都被当成一个文件来看待，几乎所有的硬件设备文件都在 /dev 这个目录下面。

下列是常见设备 在 Linux 中的文件名

|        设备        |  设备在 Linux 中的文件名  |
| :----------------: | :-----------------------: |
|      IDE硬盘       |       /dev/hd[a-d]        |
| SCSI/SATA/USB 硬盘 |       /dev/sd[a-p]        |
|        U 盘        |       /dev/sd[a-p]        |
|        软驱        |       /dev/fd[0-1]        |
|        鼠标        |      PS2: /dev/psaux      |
|        鼠标        | USB: /dev/usb/mouse[0-15] |
|      当前鼠标      |        /dev/mouse         |

 [Linux 支持的硬件设备与文件名](https://mirrors.edge.kernel.org/pub/linux/docs/lanana/device-list/devices-2.6.txt)





# 目录

###  [linux 常用命令](./commands.md)





# 参考资料

* 鸟哥的 Linux 私房菜 基础学习篇(第三版)