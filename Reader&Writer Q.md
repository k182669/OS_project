Reader&Writer Q

/**
r和w可以存取common database或其他資源
reader可以和其他無限制數量的reader共享資源
但writer必須互斥控制資源
限制1：當writer準備寫入，沒有新的reader被允許執行，reader飢餓在這裡有可能發生
限制2：當有任何waiting reader，沒有writer被允許執行，這裡writer可能會產生飢餓
必須處理飢餓問題
**/