package com.eyehail.profilecardlayout

//changed drawableId to pictureUrl
data class UserProfile(val name: String, val status: Boolean, val pictureUrl: String)


val userProfileList = arrayListOf<UserProfile>(

    UserProfile(name = "John Doe", status = true, "https://imgr.search.brave.com/EjVRJmvxstsCBe-t7Ix5NsbMoIwN60lUqzqodSmGAjI/fit/632/225/ce/1/aHR0cHM6Ly90c2Uz/Lm1tLmJpbmcubmV0/L3RoP2lkPU9JUC4t/ZmgxRjVCSDN3VWVU/Y29RN2hUdjd3SGFG/aiZwaWQ9QXBp"),

    UserProfile(name = "Amanda Wixted", status = false, "https://imgr.search.brave.com/gEy9hr2z9yJsg1xXmKrp8cUStMAqxxStPA8YEiFtANY/fit/687/225/ce/1/aHR0cHM6Ly90c2Uy/Lm1tLmJpbmcubmV0/L3RoP2lkPU9JUC5G/a2tTMkZWUTRRSHhS/X2VaWm5EY0t3SGFG/SCZwaWQ9QXBp"),
    UserProfile(name = "John Doe", status = true, "https://imgr.search.brave.com/s_eGqKFb8vmkDcGeonACZQhbvNeeEUgcI8NlVnAinzk/fit/844/225/ce/1/aHR0cHM6Ly90c2Uy/Lm1tLmJpbmcubmV0/L3RoP2lkPU9JUC5N/a0dJSms2Q082bFdC/cTEzZF9vWGR3SGFF/SyZwaWQ9QXBp"),

    UserProfile(name = "Sara Haider", status = false, "https://1.bp.blogspot.com/-EbKavOtYGcc/V0FnKtqGGSI/AAAAAAAAAT4/KcQcEs1HgbU8zpes1O49d4LTJnvZ5ArrACLcB/s1600/13220970_1557029381260577_8932776419076736831_n.jpg"),
    UserProfile(name = "John Doe", status = true, "https://imgr.search.brave.com/t6g9kc-ydRZk0-daXuUuCZiab2nQPuEtGInQdUM4V8w/fit/600/321/ce/1/aHR0cDovL21ldGFn/ZWFyc29saWQub3Jn/L3dwLWNvbnRlbnQv/dXBsb2Fkcy8yMDE0/LzAxL2Jsb2dfcHJv/Z3JhbW1lcnMuanBn"),

    UserProfile(name = "Jade Raymond", status = false, "https://4.bp.blogspot.com/-O166cCXmiyw/V0FnZZdIq9I/AAAAAAAAAT8/fHj76TXw0HEDpjnbQnigW8NvL-8k84LfwCLcB/s1600/13179285_1557029284593920_8611946504095618993_n.jpg"),
    UserProfile(name = "John Doe", status = true, "https://imgr.search.brave.com/t6g9kc-ydRZk0-daXuUuCZiab2nQPuEtGInQdUM4V8w/fit/600/321/ce/1/aHR0cDovL21ldGFn/ZWFyc29saWQub3Jn/L3dwLWNvbnRlbnQv/dXBsb2Fkcy8yMDE0/LzAxL2Jsb2dfcHJv/Z3JhbW1lcnMuanBn"),

    UserProfile(name = "Tracy Chou", status = false, "https://1.bp.blogspot.com/-IvaskgSfr_k/V0Fn4ppV40I/AAAAAAAAAUI/Of68SPnf8pMA8yuEujRCVw38OJSVwaXVgCLcB/s1600/13226736_1557029524593896_7446745577826820779_n.jpg"),
)