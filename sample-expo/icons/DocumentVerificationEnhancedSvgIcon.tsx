import * as React from "react"
import Svg, { SvgProps, Path, Defs, Mask, G } from "react-native-svg"

const DocumentVerificationEnhancedSvgIcon = (props: SvgProps) => (
    <Svg
        viewBox="0 0 130 141"
        width={128}
        height={172}
        fill="none"
        {...props}
    >
        <Path
            d="m10.9 83.9.2 69.6v.6s0 .1.1.1l.1.1.1.1-3.9-2.3-.1-.1-.1-.1s0-.1-.1-.1v-.5L7 82l3.9 2.3v-.4z"
            fill="#000"
        />
        <Path
            d="M114.1 17h.8l4.4 2.1h-.6s-.1 0-.2.1c0 0-.1 0-.2.1L12.7 80.8l-3.9-2.3L114.1 17z"
            fill="#f8ceeb"
        />
        <Path
            d="M12.7 80.8c-1 .6-1.8 1.9-1.8 3.1l.2 69.6c0 1.2.8 1.6 1.8 1l105.3-61.6c1-.6 1.8-1.9 1.8-3l-.2-69.6c0-1.2-.8-1.6-1.8-1L12.7 80.8z"
            fill="#7fcbf5"
        />
        <Path
            d="M39 125.8c8.8-5.1 16-17.5 16-27.7s-7.2-14.3-16-9.2-16 17.5-16 27.7 7.2 14.3 16 9.2z"
            fill="#f9f0e7"
        />
        <Defs />
        <Mask
            id="mask0"
            width={38}
            height={65}
            x={20}
            y={82}
            maskUnits="userSpaceOnUse"
        >
            <Path
                d="M39 125.8c8.8-5.1 16-17.5 16-27.7s-7.2-14.3-16-9.2-16 17.5-16 27.7 7.2 14.3 16 9.2z"
                fill="#fff"
            />
        </Mask>
        <G mask="url(#mask0)">
            <Path
                d="m58.2 125.3-19 11-19 11s.3-10.3 4.1-14.6c1.2-1.3 2.5-2.7 3.6-3.9l.6-.6c1.1-1.2 2.4-2.7 2.9-3.3l.1-.1.1-.1c3-3.6 3.3-6.2 3.4-11.4v-.4c1 0 2.8-.5 4.3-1.3 1.5-.9 3.4-2.7 4.3-3.7 0 2.9 0 4.9.5 6.2.5 1.2 1.3 1.8 2.8 1.8h.2c.5 0 2.1 0 3.3-.1 1 0 2.5-.2 3.6-.3 3.9-.2 4.2 9.8 4.2 9.8"
                fill="#81301f"
            />
            <Path
                d="m39.2 136.2-12.6 7.3c.5-3.2 1.5-11.1 1.4-14.8l.6-.6c1.1-1.2 2.4-2.7 2.9-3.3l.1-.1c4.1-.4 11.4-4.5 15.4-8.9h.2c.5 0 2.1 0 3.3-.1-.1 3.9.8 11.3 1.4 13.2l-12.7 7.3z"
                fill="#000"
            />
        </G>
        <Path
            d="m113 105.9 14.2-8.2-.1-16.7-5 3 .1 10.9-9.2 5.3v5.7zM0 171.2l14.5-8.4V157L5 162.6V152l-5 2.9v16.3zm.1-82.3 5-2.9L5 75.1l9.3-5.3V64L0 72.2l.1 16.7zm121.4-69.7 5-2.9V0L112 8.4v5.8l9.4-5.5.1 10.5z"
            fill="#ff9b00"
        />
        {/* Other Path elements omitted for brevity */}
    </Svg>
)

export default DocumentVerificationEnhancedSvgIcon
