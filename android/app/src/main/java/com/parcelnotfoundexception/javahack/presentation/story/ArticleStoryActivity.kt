package com.parcelnotfoundexception.javahack.presentation.story

import android.app.Activity
import android.app.ActivityOptions
import android.content.Intent
import android.os.Build
import android.view.animation.AccelerateDecelerateInterpolator
import android.widget.ImageView
import com.arellomobile.mvp.presenter.InjectPresenter
import com.arellomobile.mvp.presenter.ProvidePresenter
import com.bumptech.glide.Glide
import com.parcelnotfoundexception.javahack.R
import com.parcelnotfoundexception.javahack.presentation.BaseActivity
import kotlinx.android.synthetic.main.activity_article_story.*
import javax.inject.Inject
import javax.inject.Provider

class ArticleStoryActivity : BaseActivity(), ArticleStoryView {


    @Inject
    lateinit var provider: Provider<ArticleStoryPresenter>

    @InjectPresenter
    lateinit var presenter: ArticleStoryPresenter

    @ProvidePresenter
    fun providePresenter(): ArticleStoryPresenter = provider.get()

    override fun layoutRes() = R.layout.activity_article_story

    override fun viewCreated() {
        presenter.fetchArticle(intent.getStringExtra(EXTRA_ARTICLE_ID))
        backButton.setOnClickListener { onBackPressed() }
    }

    override fun showTitle(title: String) {
        articleStoryTitle.text = title
    }

    override fun showImage(image: String) {
        Glide.with(this)
            .load(image)
            .into(articleStoryImage)
        articleStoryCard.animate().setStartDelay(150).translationY(60f)
            .setInterpolator(AccelerateDecelerateInterpolator())
    }

    override fun showDescription(description: String) {
        articleStoryDescription.text = description
    }

    companion object {

        private const val EXTRA_ARTICLE_ID = "article_id"
        private const val ARTICLE_IMAGE = "articleImage"

        fun start(activity: Activity, articleId: String, articleImage: ImageView) {
            val intent = Intent(activity, ArticleStoryActivity::class.java)
            intent.putExtra(EXTRA_ARTICLE_ID, articleId)

            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                val options = ActivityOptions
                    .makeSceneTransitionAnimation(activity, articleImage, ARTICLE_IMAGE)
                activity.startActivity(intent, options.toBundle())
            } else {
                activity.startActivity(intent)
            }

        }

    }
}