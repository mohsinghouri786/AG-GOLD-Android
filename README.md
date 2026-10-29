# MAG GOLD Android — Full v1.0

Native Jetpack Compose Android app for XAU/USD analysis.

## Included
- Twelve Data XAU/USD feed (user API key)
- M1/M5/M15/H1 synchronization
- EMA 9/21, RSI, ATR
- Swing liquidity + sweep/reclaim detection
- BOS/CHOCH proxy, RSI divergence, volume anomaly
- Top/Bottom Catcher and Reversal vs Breakout scores
- Master LONG/SHORT/WAIT signal with confidence and grade
- ATR-based entry zone, SL, TP1/TP2/TP3
- Auto scan while app is active
- Session signal journal
- Android Keystore-encrypted API key
- GitHub Actions workflow that produces an installable debug APK

## Build an APK without installing Android Studio
1. Create a GitHub repository and upload the contents of this folder.
2. Open **Actions → Build MAG GOLD APK → Run workflow**.
3. When complete, download the **MAG-GOLD-debug-apk** artifact.
4. Extract it and install `app-debug.apk` on Android. You may need to allow installation from your browser/files app.

## Data
In the app open Settings, paste a Twelve Data API key, then tap **SAVE & TEST FEED**. All displayed prices and calculations use that same feed.

## Important
This is an analytical/research tool, not an execution bot and not a guarantee of future price movement. Feed availability/rate limits depend on your data-provider plan. The BOS/CHOCH, order-block and FVG fields are algorithmic approximations and should be validated before live trading.

## OpenAI reasoning
The app intentionally does not embed an OpenAI API secret. A production AI layer should call OpenAI through a server-side proxy so the secret cannot be extracted from the APK. The deterministic MAG engine is fully local and operational without OpenAI.
