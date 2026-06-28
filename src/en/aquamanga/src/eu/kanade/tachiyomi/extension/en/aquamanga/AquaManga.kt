package eu.kanade.tachiyomi.extension.en.aquamanga

import eu.kanade.tachiyomi.multisrc.madara.Madara

// Kept intentionally minimal — a plain Madara source, the same approach the
// Kotatsu parser uses for this site (which works reliably).
//
// The site is behind a Cloudflare "Just a moment..." JS challenge that only the
// app's WebView can solve. The clearance cookie it returns is fingerprint-bound,
// so the extension must NOT add a custom User-Agent, randomized X-Requested-With,
// Sec-Fetch headers, or a custom OkHttp client. Doing so makes the okhttp
// request fingerprint diverge from the WebView that obtained the cookie, causing
// Cloudflare to reject the clearance and re-challenge on every request — which
// surfaced as repeated NullPointerExceptions while parsing the challenge page.
class AquaManga : Madara("Aqua Manga", "https://aquareader.net", "en") {
    override val useLoadMoreRequest = LoadMoreStrategy.Never

    override val chapterUrlSuffix = ""
}
