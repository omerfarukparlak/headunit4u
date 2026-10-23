package com.parlaktech.headunit4u.main

import android.os.Build
import android.os.Bundle
import android.text.Html
import android.text.Spanned
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.parlaktech.headunit4u.R
import com.google.android.material.appbar.MaterialToolbar
import java.util.Calendar

class AboutFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        return inflater.inflate(R.layout.fragment_about, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val toolbar = view.findViewById<MaterialToolbar>(R.id.toolbar)
        toolbar.setNavigationOnClickListener {
            findNavController().popBackStack()
        }

        val copyrightText = view.findViewById<TextView>(R.id.copyright_text)
        val currentYear = Calendar.getInstance().get(Calendar.YEAR)
        copyrightText.text = getString(R.string.copyright, currentYear)

        val contentText = view.findViewById<TextView>(R.id.about_content_text)

        val sb = StringBuilder()
        // Not: baslik "About HeadUnit4u"i fragment_about.xml zaten yaziyor
        // (TextView id=app_name, textAppearanceHeadlineMedium). Burada sadece
        // govde metnine basla, baslik tekrarlama.
        sb.append("Phone / tablet turned into a real Android Auto head unit. Open source, AGPLv3, built by parlaktech.<br/><br/>")
        sb.append("<a href=\"https://github.com/omerfarukparlak/headunit4u\">github.com/omerfarukparlak/headunit4u</a><br/><br/>")

        sb.append("<h3>Lineage</h3>")
        sb.append("HeadUnit4u is a fork of <a href=\"https://github.com/andrerinas/open-headunit\">andrerinas/open-headunit</a> (AGPLv3), ")
        sb.append("which itself grew from Michael Reid\'s original <a href=\"https://github.com/mikereidis/headunit\">headunit</a> — the first open implementation of the Android Auto head-unit protocol.<br/><br/>")

        sb.append("<h3>Issues &amp; feedback</h3>")
        sb.append("Report bugs or suggest changes on our GitHub issue tracker:<br/>")
        sb.append("<a href=\"https://github.com/omerfarukparlak/headunit4u/issues\">github.com/omerfarukparlak/headunit4u/issues</a><br/><br/>")

        sb.append(parseMarkdownToHtml(readAsset("CHANGELOG.md")))
        sb.append("<br/><br/>")

        sb.append("<h3>LICENSE</h3>")
        // License is plain text, preserve newlines
        val license = readAsset("LICENSE").replace("\n", "<br/>")
        sb.append(license)

        contentText.text = fromHtml(sb.toString())
        contentText.movementMethod = android.text.method.LinkMovementMethod.getInstance() // Make links clickable
    }

    private fun readAsset(fileName: String): String {
        return try {
            requireContext().assets.open(fileName).bufferedReader().use { it.readText() }
        } catch (e: Exception) {
            "Error loading $fileName"
        }
    }

    private fun parseMarkdownToHtml(markdown: String): String {
        var html = markdown
        // Headers
        html = html.replace(Regex("### (.*)"), "<h4>$1</h4>")
        html = html.replace(Regex("## (.*)"), "<h3>$1</h3>")
        html = html.replace(Regex("# (.*)"), "<h2>$1</h2>")

        // Links [text](url) -> <a href="url">text</a>. Markdown bu notasyonu
        // kullandigi anda parse edilmezse ekranda duz metin + parantezli URL
        // olarak kalir, hem cirkin hem tikanamiyor olur.
        html = html.replace(Regex("\\[([^\\]]+)\\]\\(([^)]+)\\)"), "<a href=\"$2\">$1</a>")

        // Bold
        html = html.replace(Regex("\\*\\*(.*?)\\*\\*"), "<b>$1</b>")

        // Lists
        html = html.replace(Regex("\n- (.*)"), "<br/>&#8226; $1")
        
        // Newlines (Markdown preserves single newlines as space, but we want break for readability in log?)
        // Actually, let's just replace double newlines with paragraph, and single with br?
        // Simple approach: Replace \n with <br/> but be careful not to break tags.
        // For list items we already handled the newline prefix.
        
        // Let's replace remaining newlines that are not part of tags
        // This is tricky with regex. 
        // Better: replace all \n with <br/> at the end?
        // The list replacement consumed the \n before the dash.
        
        return html
    }

    private fun fromHtml(html: String): Spanned {
        return if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            Html.fromHtml(html, Html.FROM_HTML_MODE_LEGACY)
        } else {
            @Suppress("DEPRECATION")
            Html.fromHtml(html)
        }
    }
}
