package com.example.mystore;

import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class HomePageAdapter extends RecyclerView.Adapter {


    private List<HomePageModel> homePageModelList;

    private RecyclerView.RecycledViewPool recycledViewPool;

    public HomePageAdapter(List<HomePageModel> homePageModelList) {
        this.homePageModelList = homePageModelList;
        this.recycledViewPool = new RecyclerView.RecycledViewPool();
    }


    @Override
    public int getItemViewType(int position) {

        switch (homePageModelList.get(position).getType()) {
            case 0:
                return HomePageModel.BANNER_SLIDER;

            case 1:
                return HomePageModel.STRIP_BANNER;

            case 2:
                return HomePageModel.HORIZONTAL_PRODUCT_VIEW;

            case 3:
                return HomePageModel.GRID_PRODUCT_VIEW;

            default:
                return -1;

        }
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {

        switch (viewType) {
            case HomePageModel.BANNER_SLIDER:
                View Bannerview = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.sliding_ad_layout, viewGroup, false);
                return new BannerSliderViewHplder(Bannerview);

            case HomePageModel.STRIP_BANNER:
                View Stripview = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.strip_ad_layout, viewGroup, false);
                return new StripAdBannerViewHolder(Stripview);

            case HomePageModel.HORIZONTAL_PRODUCT_VIEW:
                View horizontalview = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.horizontal_scroll_layout, viewGroup, false);
                return new HorizontalProductView(horizontalview);

            case HomePageModel.GRID_PRODUCT_VIEW:
                View gridviewt = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.grid_product_layout, viewGroup, false);
                return new GridProductVireHolder(gridviewt);

            default:
                return null;
        }


    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int position) {

        switch (homePageModelList.get(position).getType()) {
            case HomePageModel.BANNER_SLIDER:
                List<SliderModel> sliderModelList = homePageModelList.get(position).getSliderModelList();
                ((BannerSliderViewHplder) viewHolder).setBannersliderViewpager(sliderModelList);
                break;

            case HomePageModel.STRIP_BANNER:
                String resource = homePageModelList.get(position).getResource();
                String color = homePageModelList.get(position).getBackgroundcolor();
                ((StripAdBannerViewHolder) viewHolder).setStripAd(resource, color);
                break;

            case HomePageModel.HORIZONTAL_PRODUCT_VIEW:

                String colorlayout=homePageModelList.get(position).getBackgroundcolor();
                String horizontaltitle = homePageModelList.get(position).getTitle();
                List<HorizontalProductModel> horizontalProductModelList = homePageModelList.get(position).getHorizontalProductModelList();
                ((HorizontalProductView) viewHolder).setHorizontalProductLayout(horizontalProductModelList, horizontaltitle,colorlayout);
                break;


            case HomePageModel.GRID_PRODUCT_VIEW:

                String gridtitle = homePageModelList.get(position).getTitle();
                List<HorizontalProductModel> GridProductModelListt = homePageModelList.get(position).getHorizontalProductModelList();
                ((GridProductVireHolder) viewHolder).setGridLayout(GridProductModelListt, gridtitle);
                break;


            default:
                return;

        }

    }

    @Override
    public int getItemCount() {
        return homePageModelList.size();
    }

    public class BannerSliderViewHplder extends RecyclerView.ViewHolder {


        private ViewPager bannersliderViewpager;
        private Timer timer;
        private int currentPage;
        final private long delay_time = 3000;
        final private long period_time = 3000;
        private List<SliderModel> arrangedList;

        public BannerSliderViewHplder(@NonNull View itemView) {

            super(itemView);

            bannersliderViewpager = itemView.findViewById(R.id.banner_viewpager);


        }

        private void setBannersliderViewpager(final List<SliderModel> sliderModelList) {

            currentPage=2;

            if(timer!=null)
            {
                timer.cancel();
            }
            arrangedList=new ArrayList<>();
            for(int x=0;x<sliderModelList.size();x++)
            {
                arrangedList.add(x,sliderModelList.get(x));
            }

            arrangedList.add(0,sliderModelList.get(sliderModelList.size()-2));
            arrangedList.add(1,sliderModelList.get(sliderModelList.size()-1));
            arrangedList.add(sliderModelList.get(0));
            arrangedList.add(sliderModelList.get(1));

            SliderAdapter sliderAdapter = new SliderAdapter(arrangedList);
            bannersliderViewpager.setAdapter(sliderAdapter);
            bannersliderViewpager.setClipToPadding(false);

            bannersliderViewpager.setPageMargin(20);

            bannersliderViewpager.setCurrentItem(currentPage);

            ViewPager.OnPageChangeListener onPageChangeListener = new ViewPager.OnPageChangeListener() {
                @Override
                public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {


                }

                @Override
                public void onPageSelected(int position) {
                    currentPage = position;

                }



                @Override
                public void onPageScrollStateChanged(int state) {
                    if (state == ViewPager.SCROLL_STATE_IDLE) ;
                    pageLooper(arrangedList);

                }
            };


            bannersliderViewpager.addOnPageChangeListener(onPageChangeListener);


            startBannerSlideShow(arrangedList);

            bannersliderViewpager.setOnTouchListener(new View.OnTouchListener() {
                @Override
                public boolean onTouch(View v, MotionEvent event) {

                    pageLooper(arrangedList);
                    stopBannerSlideShow();

                    if (event.getAction() == MotionEvent.ACTION_UP) {
                        startBannerSlideShow(arrangedList);
                    }
                    return false;
                }
            });


        }

        private void pageLooper(List<SliderModel> sliderModelList) {
            if (currentPage == sliderModelList.size() - 2) {
                currentPage = 2;
                bannersliderViewpager.setCurrentItem(currentPage, false);
            } else if (currentPage == 1) {
                currentPage = sliderModelList.size() - 3;
                bannersliderViewpager.setCurrentItem(currentPage, false);
            }

        }

        private void startBannerSlideShow(final List<SliderModel> sliderModelList) {
            final Handler handler = new Handler();
            final Runnable update = new Runnable() {
                @Override
                public void run() {
                    if (currentPage >= sliderModelList.size()) {
                        currentPage = 1;
                    }
                    bannersliderViewpager.setCurrentItem(currentPage++);

                }
            };

            timer = new Timer();
            timer.schedule(new TimerTask() {
                @Override
                public void run() {
                    handler.post(update);

                }
            }, delay_time, period_time);
        }

        private void stopBannerSlideShow() {
            timer.cancel();
        }
    }

    public class StripAdBannerViewHolder extends RecyclerView.ViewHolder {

        private ImageView stripImage;
        private ConstraintLayout stripadContainer;

        public StripAdBannerViewHolder(@NonNull View itemView) {


            super(itemView);

            stripImage = itemView.findViewById(R.id.strip_ad);
            stripadContainer = itemView.findViewById(R.id.strip_ad_container);
        }

        private void setStripAd(String resource, String color) {
            Glide.with(itemView.getContext()).load(resource).apply(new RequestOptions().placeholder(R.drawable.ic_baseline_add_circle_outline_24))
                    .into(stripImage);
            stripadContainer.setBackgroundColor(Color.parseColor(color));
        }


    }

    public class HorizontalProductView extends RecyclerView.ViewHolder {

        private ConstraintLayout container1;
        private TextView horizontallayouttitle;
        private Button horizontalViewallButton;
        private RecyclerView horizontalrecycleview;


        public HorizontalProductView(@NonNull View itemView) {
            super(itemView);

            container1= itemView.findViewById(R.id.container1);
            horizontallayouttitle = itemView.findViewById(R.id.horizontal_scrolllayout_textview);
            horizontalrecycleview = itemView.findViewById(R.id.horizontal_scrolllayout_recyclerview);
            horizontalViewallButton = itemView.findViewById(R.id.horizontal_scrolllayout_button);
            horizontalrecycleview.setRecycledViewPool(recycledViewPool);

        }

        private void setHorizontalProductLayout(List<HorizontalProductModel> horizontalProductModelList, String title,String color) {
           container1.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor(color)));
            horizontallayouttitle.setText(title);

            if (horizontalProductModelList.size() > 8) {
                horizontalViewallButton.setVisibility(View.VISIBLE);

                horizontalViewallButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(itemView.getContext(), ViewAllActivity.class);
                        intent.putExtra("layout_code", 0);
                        itemView.getContext().startActivity(intent);
                    }
                });
            } else {
                horizontalViewallButton.setVisibility(View.INVISIBLE);
            }
            HorizontalProductAdapter horizontalProductAdapter = new HorizontalProductAdapter(horizontalProductModelList);
            LinearLayoutManager linearLayoutManager1 = new LinearLayoutManager(itemView.getContext());
            linearLayoutManager1.setOrientation(RecyclerView.HORIZONTAL);
            horizontalrecycleview.setLayoutManager(linearLayoutManager1);
            horizontalrecycleview.setAdapter(horizontalProductAdapter);
            horizontalProductAdapter.notifyDataSetChanged();
        }
    }

    public class GridProductVireHolder extends RecyclerView.ViewHolder {

        private TextView gridlayouttitle;
        private Button gridlayoutviewall;
        private GridLayout gridViewproduct;

        public GridProductVireHolder(@NonNull View itemView) {
            super(itemView);

            gridlayouttitle = itemView.findViewById(R.id.grid_layout_product_title);
            gridlayoutviewall = itemView.findViewById(R.id.grrid_product_view_all_b);
            gridViewproduct = itemView.findViewById(R.id.product_layout_gridview);
        }


        private void setGridLayout(List<HorizontalProductModel> horizontalProductModelList, String title) {
            gridlayouttitle.setText(title);
            /// gridViewproduct.setAdapter(new GridProductViewAdapter(horizontalProductModelList));

            for (int x = 0; x < 4; x++) {
                ImageView productImage = gridViewproduct.getChildAt(x).findViewById(R.id.HS_product_image);
                TextView productTitle = gridViewproduct.getChildAt(x).findViewById(R.id.HS_product_title);
                TextView productPrice = gridViewproduct.getChildAt(x).findViewById(R.id.HS_product_price);
                TextView productDescription = gridViewproduct.getChildAt(x).findViewById(R.id.HS_product_decription);

              //  Glide.with(itemView.getContext()).load(horizontalProductModelList.get(po))
                productTitle.setText(horizontalProductModelList.get(x).getProducttitle());
                productDescription.setText(horizontalProductModelList.get(x).getProductDescription());
                productPrice.setText(horizontalProductModelList.get(x).getProductprice());
                gridViewproduct.getChildAt(x).setBackgroundColor(Color.parseColor("#ffffff"));
                gridViewproduct.getChildAt(x).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(itemView.getContext(), ProductsDetailsActivity.class);
                        itemView.getContext().startActivity(intent);
                    }
                });
            }
            gridlayoutviewall.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(itemView.getContext(), ViewAllActivity.class);
                    intent.putExtra("layout_code", 1);
                    itemView.getContext().startActivity(intent);
                }
            });
        }
    }
}
